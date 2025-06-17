/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.recibos.entrega.ReciboEntrega;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.FabStatusNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.estrategiaNotificacao.FabTipoEstrategiaMidiaNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.FabLogDisparoComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.ErroEmBancoDeDados;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import java.util.Date;
import java.util.List;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.CPNotificacaoSB;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroAcessandoCanalComunicacao;

/**
 *
 * @author salvio
 */
public class ModuloNotificacao extends ControllerAbstratoSBPersistencia {

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_REGISTRAR_NOTIFICACAO)
    public static ItfRespostaAcaoDoSistema notificacaoRegistrar(NotificacaoSB pNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pNotificacao), pNotificacao) {
            @Override
            public void executarAcoesFinais() throws ErroEmBancoDeDados {
                super.executarAcoesFinais();
                if (isSucesso()) {

                    notificacaoEnviar((NotificacaoSB) getRetorno());

                }
            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                if (pNotificacao.getUsuario() == null) {
                    throw new ErroRegraDeNegocio("O usuário para notificação não foi definido");
                }

                NotificacaoSB notificacaoAtualizada = atualizarEntidade(pNotificacao, true);

                if (notificacaoAtualizada.getDialogo() == null) {
                    throw new ErroRegraDeNegocio("Falha gerando dialogo da notificação");
                }
                notificacaoAtualizada.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());
                notificacaoAtualizada.setCodigoSeloComunicacao(notificacaoAtualizada.getDialogo().getCodigoSelo());

                setRetorno(atualizarEntidade(notificacaoAtualizada));

            }
        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_ENVIAR_NOTIFICACAO_REGISTRADA)
    public static synchronized ItfRespostaAcaoDoSistema notificacaoEnviar(NotificacaoSB pNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pNotificacao), pNotificacao) {
            @Override
            public void executarAcoesFinais() throws ErroEmBancoDeDados {

            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                NotificacaoSB notificacao = loadEntidade(pNotificacao);
                if (!notificacao.getStatus().equals(FabStatusNotificacao.REGISTRADA.getRegistro())) {
                    throw new ErroRegraDeNegocio("A notificação precisa estar no status Registrada");
                }
                ItfDialogo dialogo = SBCore.getServicoComunicacao().getComnunicacaoRegistrada(notificacao.getCodigoSeloComunicacao());

                for (FabLogDisparoComunicacao tipoLogComunicacao : FabLogDisparoComunicacao.values()) {
                    if (!tipoLogComunicacao.isMarcadoParaNotificar(notificacao.getTipoNotificacao())
                            || !tipoLogComunicacao.getCanal().isTipoTransporteImplementado()) {
                        continue;
                    }

                    try {
                        LogDisparoNotificacao disparo = tipoLogComunicacao.getRegistro(notificacao);
                        // ItfDialogo dialogoJaRestistrado = SBCore.getServicoComunicacao().getArmazenamento().getDialogoByCodigoSelo(disparo.getNotificacao().getCodigoSeloComunicacao());
                        if (dialogo == null) {

                            dialogo = SBCore.getServicoComunicacao().registrarDialogo(disparo.getNotificacao().getCodigoSeloComunicacao(), disparo.getNotificacao().getDialogo());
                        }
                        String codigoEnvio = SBCore.getServicoComunicacao().dispararComunicacao(dialogo, tipoLogComunicacao.getCanal());
                        if (codigoEnvio != null) {

                            disparo.setCodigoRegistroEnvio(codigoEnvio);
                            disparo.setReciboEntrega(new ReciboEntrega());
                            disparo.getReciboEntrega().setDisparo(disparo);
                            disparo.getReciboEntrega().setCodigoEntrega(codigoEnvio);
                            notificacao.getDisparos().add(disparo);

                        }
                    } catch (Throwable t) {
                        SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha enviando notificacção v ia" + tipoLogComunicacao, t);
                    }

                }

                if (!notificacao.getDisparos().isEmpty()) {
                    notificacao.setStatus(FabStatusNotificacao.ENVIADA.getRegistro());
                }
                UtilSBPersistencia.mergeRegistro(notificacao);
            }
        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_ENVIO_AUTO_EXEC)
    public static synchronized ItfRespostaAcaoDoSistema notificacoesEnviar() {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(new NotificacaoSB()), new NotificacaoSB()) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                ConsultaDinamicaDeEntidade novaConsulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, getEm());
                novaConsulta.addCondicaoManyToOneIgualA(CPNotificacaoSB.status, FabStatusNotificacao.REGISTRADA.getRegistro());

                List<NotificacaoSB> notiticacoes = novaConsulta.gerarResultados();

                for (NotificacaoSB notificacao : notiticacoes) {

                    if (notificacao.getDisparos().stream().filter(disp -> disp.getReciboEntrega() != null).findFirst().isPresent()) {
                        notificacao.setStatus(FabStatusNotificacao.ENTREGUE.getRegistro());
                        UtilSBPersistencia.mergeRegistro(notificacao);
                        continue;
                    }
                    notificacaoEnviar(notificacao);
                }
            }

        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_LEITURA_AUTO_EXEC)
    public static synchronized ItfRespostaAcaoDoSistema notificacaoProcessarLeitura() {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(new NotificacaoSB()), new NotificacaoSB()) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                ConsultaDinamicaDeEntidade novaConsulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, getEm());
                novaConsulta.addCondicaoManyToOneIgualA(CPNotificacaoSB.status, FabStatusNotificacao.ENVIADA.getRegistro());

                List<NotificacaoSB> notiticacoes = novaConsulta.gerarResultados();

                for (NotificacaoSB notificacao : notiticacoes) {

                    if (notificacao.getDisparos().stream().filter(disp -> disp.getReciboLeitura() != null).findFirst().isPresent()) {
                        notificacao.setStatus(FabStatusNotificacao.LIDA.getRegistro());
                        UtilSBPersistencia.mergeRegistro(notificacao);
                        continue;
                    }

                    if (notificacao.getTipoNotificacao().getMinutosRenotificacao() > 0) {

                        if (!notificacao.getTipoNotificacao().isExigirReciboDeEntrega() && notificacao.getTipoNotificacao().isExigirReciboLeitura()) {
                            notificacao.setStatus(FabStatusNotificacao.ENCERRADA_SEM_CONFIRMACAO.getRegistro());
                            UtilSBPersistencia.mergeRegistro(notificacao);
                            continue;
                        }

                        Date dataHoraUltimoDisparo = notificacao.getDisparos().get(0).getDataHoraDisparo();
                        long diferencaUltimaNotificacao = UtilSBCoreDataHora.intervaloTempoMinutos(dataHoraUltimoDisparo, new Date());
                        long diasDisparo = UtilSBCoreDataHora.intervaloTempoDias(notificacao.getDataRegistroNotificacao(), new Date());
                        if (diasDisparo > notificacao.getTipoNotificacao().getDiasLog()) {
                            continue;
                        }

                        if (diferencaUltimaNotificacao > notificacao.getTipoNotificacao().getMinutosRenotificacao()) {

                            List<FabLogDisparoComunicacao> medias = FabTipoEstrategiaMidiaNotificacao.PROGRESSIVA.getMedias(notificacao);
                            ItfDialogo dialogo = SBCore.getServicoComunicacao().getComnunicacaoRegistrada(notificacao.getCodigoSeloComunicacao());
                            for (FabLogDisparoComunicacao logCOmunicacao : medias) {
                                String codigoDisparo;
                                try {
                                    codigoDisparo = SBCore.getServicoComunicacao().dispararComunicacao(dialogo, logCOmunicacao.getCanal());
                                    if (codigoDisparo != null) {
                                        LogDisparoNotificacao disparo = logCOmunicacao.getRegistro(notificacao);
                                        disparo.setFoiEnviado(true);
                                        disparo.setCodigoRegistroEnvio(codigoDisparo);
                                        notificacao.getDisparos().add(disparo);

                                    } else {
                                        LogDisparoNotificacao disparo = logCOmunicacao.getRegistro(notificacao);
                                        disparo.setFoiEnviado(false);
                                        disparo.setCodigoRegistroEnvio(null);
                                        notificacao.getDisparos().add(disparo);
                                    }
                                } catch (ErroAcessandoCanalComunicacao ex) {
                                    //throw new ErroRegraDeNegocio("");
                                }

                            }

                        }

                    }

                    UtilSBPersistencia.mergeRegistro(notificacao);
                }
            }

        };
    }

}
