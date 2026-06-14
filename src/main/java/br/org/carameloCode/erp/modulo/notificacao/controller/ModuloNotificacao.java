/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.notificacao.api.InfoAcaoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.ItfERPNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.recibos.entrega.ReciboEntrega;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.estrategiaNotificacao.FabTipoEstrategiaMidiaNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.recibos.leitura.ReciboLeitura;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.FabLogDisparoComunicacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.ErroEmBancoDeDados;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCDataHora;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import java.util.Date;
import java.util.List;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroAcessandoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroRegistrandoDialogo;

/**
 *
 * @author salvio
 */
public class ModuloNotificacao extends ControllerAbstratoSBPersistencia {

    private final static ItfERPNotificacao SERVICO_NOTIFICACAO_PADRAO = CarameloCode.getServicoERP(ERPNotificacoes.NOTIFICACAO_PADRAO);

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_REGISTRAR_NOTIFICACAO)
    public static ItfRespostaAcaoDoSistema notificacaoRegistrar(NotificacaoSB pNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pNotificacao), pNotificacao) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                if (pNotificacao.getUsuario() == null) {
                    throw new ErroRegraDeNegocio("O usuário para notificação não foi definido");
                }
                UsuarioSB usuario = loadEntidade(pNotificacao.getUsuario());
                if (pNotificacao.getStatus() == null) {
                    pNotificacao.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());
                }
                if (!usuario.isAtivo()) {
                    throw new ErroRegraDeNegocio("usuário está desativado");
                }
                NotificacaoSB notificacaoAtualizada = atualizarEntidade(pNotificacao, true);

                if (notificacaoAtualizada.getDialogo() == null) {
                    throw new ErroRegraDeNegocio("Falha gerando dialogo da notificação");
                }
                notificacaoAtualizada.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());
                notificacaoAtualizada.setDataRegistroNotificacao(new Date());
                if (notificacaoAtualizada instanceof NotificacaoUsrParaUsr) {

                }
                int diasNotificacaoValida = notificacaoAtualizada.getTipoNotificacao().getDiasLog();
                if (diasNotificacaoValida < 7) {
                    diasNotificacaoValida = 7;
                }
                notificacaoAtualizada.setDataExpiraNotificacao(UtilCRCDataHora.incrementaDias(new Date(), diasNotificacaoValida));

                notificacaoAtualizada.setCodigoSeloComunicacao(notificacaoAtualizada.getDialogo().getCodigoSelo());
                adicionarGatilhoExecucaoFinalComSucesso(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_ENVIAR_NOTIFICACAO_REGISTRADA, notificacaoAtualizada);
                setRetorno(atualizarEntidade(notificacaoAtualizada));

            }
        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_ENVIAR_NOTIFICACAO_REGISTRADA)
    public static synchronized ItfRespostaAcaoDoSistema notificacaoEnviar(NotificacaoSB pNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pNotificacao), pNotificacao) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                NotificacaoSB notificacao = loadEntidade(pNotificacao);
                if (!notificacao.getStatus().equals(FabStatusNotificacao.REGISTRADA.getRegistro())) {
                    throw new ErroRegraDeNegocio("A notificação precisa estar no status Registrada");
                }
                String codigoSelo = notificacao.getCodigoSeloComunicacao();
                if (codigoSelo == null) {
                    codigoSelo = String.valueOf(notificacao.getId());

                }

                for (FabLogDisparoComunicacao tipoLogComunicacao : FabLogDisparoComunicacao.values()) {
                    if (!tipoLogComunicacao.isMarcadoParaNotificar(notificacao.getTipoNotificacao())
                            || !tipoLogComunicacao.getCanal().isTipoTransporteImplementado()) {
                        continue;
                    }

                    try {
                        LogDisparoNotificacao disparo = tipoLogComunicacao.getRegistro(notificacao);
                        // ItfDialogo dialogoJaRestistrado = SBCore.getServicoComunicacao().getArmazenamento().getDialogoAtivoByCodigoSelo(disparo.getNotificacao().getCodigoSeloComunicacao());

                        try {

                            String codigoEnvio = SBCore.getServicoComunicacao().dispararComunicacao(notificacao.getDialogo(), tipoLogComunicacao.getCanal());

                            if (codigoEnvio != null) {

                                disparo.setCodigoRegistroEnvio(codigoEnvio);
                                disparo.setReciboEntrega(new ReciboEntrega());
                                disparo.getReciboEntrega().setDisparo(disparo);
                                disparo.getReciboEntrega().setCodigoEntrega(codigoEnvio);
                                //Ao adicionar em um persistencebag, com transação ativa, o disparo será persistido no banco de dados
                                notificacao.getDisparos().add(disparo);

                            }
                        } catch (ErroAcessandoCanalComunicacao erro) {
                            System.out.println();
                            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "A notificação da mensagem " + notificacao.getId() + " não é compatível com " + tipoLogComunicacao, erro);
                        }

                    } catch (Throwable t) {
                        SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha enviando notificacção " + notificacao.getId() + " via: " + tipoLogComunicacao, t);
                    }

                }

                if (!notificacao.getDisparos().isEmpty()) {
                    notificacao.setStatus(FabStatusNotificacao.ENVIADA.getRegistro());
                }

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
                    if (notificacao.getDataExpiraNotificacao() == null || UtilCRCDataHora.isDiaIgualOuSuperior(new Date(), notificacao.getDataExpiraNotificacao())) {
                        removerEntidade(notificacao);
                    } else {
                        if (notificacao.getDisparos().stream().filter(disp -> disp.getReciboEntrega() != null).findFirst().isPresent()) {
                            notificacao.setStatus(FabStatusNotificacao.ENTREGUE.getRegistro());
                            UtilSBPersistencia.mergeRegistro(notificacao);
                            continue;
                        }

                        notificacaoEnviar(notificacao);
                    }
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
                        long diferencaUltimaNotificacao = UtilCRCDataHora.intervaloTempoMinutos(dataHoraUltimoDisparo, new Date());
                        long diasDisparo = UtilCRCDataHora.intervaloTempoDias(notificacao.getDataRegistroNotificacao(), new Date());
                        if (diasDisparo > notificacao.getTipoNotificacao().getDiasLog()) {
                            continue;
                        }

                        if (diferencaUltimaNotificacao > notificacao.getTipoNotificacao().getMinutosRenotificacao()) {
                            FabTipoEstrategiaMidiaNotificacao estrategia = notificacao.getTipoNotificacao().getEstrategia();
                            List<FabLogDisparoComunicacao> medias = estrategia.getMedias(notificacao);
                            ItfDialogo dialogo = notificacao.getDialogo();
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

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.RECIBO_CTR_SALVAR_MERGE)
    public static synchronized ItfRespostaAcaoDoSistema reciboResposta(ReciboLeitura recibo) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(new NotificacaoSB()), new NotificacaoSB()) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                if (recibo.getDisparo() == null) {
                    throw new ErroRegraDeNegocio("Disparo não definido");
                }
                if (recibo.getCodigoLeitura() == null) {
                    throw new ErroRegraDeNegocio("Informe o código da leitura");
                }
                LogDisparoNotificacao logDisparo = loadEntidade(recibo.getDisparo());
                NotificacaoSB notificacao = logDisparo.getNotificacao();
                notificacao.setStatus(FabStatusNotificacao.LIDA.getRegistro());
                adicionarGatilhoExecucaoFinalComSucesso(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_ATUALIZAR_REPOSITORIO_LOCAL, notificacao);
                if (notificacao.getTipoNotificacao() != null) {
                    if (notificacao.getTipoNotificacao() instanceof TipoNotificacaoUsrComUsr) {
                        TipoNotificacaoUsrComUsr tiponotificacaoUrsToSr = notificacao.getTipoNotificacao().getComoTiponotificacaoUsrToUsr();
                        if (tiponotificacaoUrsToSr.isNotificarDestinatario()) {
                            NotificacaoUsrParaUsr notificacaoOrigem = notificacao.getComoNotificacaoUsuarioParaUsuario();
                            NotificacaoRespostaAguardada novaNotificacao = new NotificacaoRespostaAguardada();
                            novaNotificacao.setNotificacaoOrigem(notificacao);
                            novaNotificacao.setTipoNotificacao(notificacao.getTipoNotificacao());
                            notificacao.setUsuario(notificacaoOrigem.getUsuarioAguardandoResposta());
                            notificacao = atualizarEntidade(notificacao);
                            adicionarGatilhoExecucaoFinalComSucesso(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_REGISTRAR_NOTIFICACAO, novaNotificacao);
                        }
                    }
                }
                atualizarEntidade(recibo);
            }

        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.NOTIFICACAO_CTR_ATUALIZAR_REPOSITORIO_LOCAL)
    public static ItfRespostaAcaoDoSistema notificaoAtualizarRepLocal(NotificacaoSB pNotificao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(new NotificacaoSB()), new NotificacaoSB()) {

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                NotificacaoSB ntf = loadEntidade(pNotificao);
                if (ntf.getStatus() != null && ntf.getStatus().equals(FabStatusNotificacao.ENVIADA.getRegistro())) {
                    try {
                        CarameloCode.getServicoComunicacao().getArmazenamento().registrarDialogoAtivo(ntf.getDialogo());
                    } catch (ErroRegistrandoDialogo ex) {
                        addErro("Falha registrando Dialogo Ativo" + ex.getMessage());
                    }
                } else if (ntf.getStatus() != null && ntf.getStatus().equals(FabStatusNotificacao.LIDA.getRegistro())) {
                    CarameloCode.getServicoComunicacao().getArmazenamento().removerDialogoAtivo(pNotificao.getCodigoSeloComunicacao());
                }
            }

        };
    }

    @InfoAcaoNotificacao(acao = FabAcaoNotificacaoPadraoSB.TIPO_NOTIFICACAO_CTR_SALVAR_MERGE)
    public static synchronized ItfRespostaAcaoDoSistema tipoNotificacaoSalvar(TipoNotificacao pTipoNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(new NotificacaoSB()), new NotificacaoSB()) {
            @Override
            public void executarAcoesFinais() throws ErroEmBancoDeDados {
                super.executarAcoesFinais(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
            }

            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {
                atualizarEntidade(pTipoNotificacao, true);
            }

        };
    }

}
