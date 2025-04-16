/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.recibos.entrega.ReciboEntrega;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.FabStatusNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
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
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreListasObjeto;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabStatusComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;
import java.util.Date;
import java.util.List;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.CPNotificacaoSB;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

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
                    if (!SBCore.isEmModoDesenvolvimento()) {
                        notificacaoEnviar();
                    }
                }
            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                ItfComunicacao comunicacao = SBCore.getServicoComunicacao()
                        .iniciarComunicacaoSistema_Usuairo(FabTipoComunicacao.NOTIFICAR,
                                pNotificacao.getUsuario(), pNotificacao.getConteudoHtml(), ERPTipoCanalComunicacao.EMAIL);
                pNotificacao.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());
                atualizarEntidade(pNotificacao, true);

            }
        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_ENVIO_AUTO_EXEC)
    public static synchronized ItfRespostaAcaoDoSistema notificacaoEnviar() {
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

                    for (FabLogDisparoComunicacao tipoLogComunicacao : FabLogDisparoComunicacao.values()) {
                        if (!tipoLogComunicacao.isMarcadoParaNotificar(notificacao.getTipoNotificacao())
                                || !tipoLogComunicacao.getTRansporte().isTipoTransporteImplementado()) {
                            continue;
                        }

                        LogDisparoNotificacao disparo = tipoLogComunicacao.getRegistro(notificacao);
                        try {

                            ItfComunicacao comunicacao = SBCore.getServicoComunicacao().iniciarComunicacaoSistema_Usuairo(FabTipoComunicacao.NOTIFICAR, notificacao.getUsuario(),
                                    notificacao.getAssunto(), notificacao.getConteudoHtml(), disparo.getTipoTransporte());
                            disparo.setCodigoRegistroEnvio(comunicacao.getCodigoSelo());

                        } catch (Throwable t) {
                            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha enviando notificacção v ia" + tipoLogComunicacao, t);
                        }

                    }

                    if (!notificacao.getDisparos().isEmpty()) {
                        notificacao.setStatus(FabStatusNotificacao.ENVIADA.getRegistro());
                    }
                    UtilSBPersistencia.mergeRegistro(notificacao);
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

                            for (FabLogDisparoComunicacao midia : medias) {
                                ItfComunicacao comunicacao = SBCore.getServicoComunicacao().iniciarComunicacaoSistema_Usuairo(FabTipoComunicacao.NOTIFICAR, notificacao.getUsuario(),
                                        notificacao.getAssunto(), notificacao.getConteudoHtml(), ERPTipoCanalComunicacao.MATRIX);

                                LogDisparoNotificacao disparo = midia.getRegistro(notificacao);
                                if (comunicacao.getCodigoSelo() != null) {
                                    disparo.setCodigoRegistroEnvio(comunicacao.getCodigoSelo());
                                }
                                notificacao.getDisparos().add(disparo);

                            }

                        }

                    }

                    UtilSBPersistencia.mergeRegistro(notificacao);
                }
            }

        };
    }

}
