package br.org.coletivoJava.fw.erp.implementacao.notificação;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.notificação.NotificaNotificacaoPadrao;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoDialogo;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.ItfERPNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.logdisparonotificacao.CPLogDisparoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.controller.ModuloNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.DialogoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.recibos.leitura.ReciboLeitura;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import com.google.common.collect.Lists;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCReflexaoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

@NotificaNotificacaoPadrao
public class NotificaNotificacaoPadraoimpl extends RepositorioLinkEntidadesGenerico
        implements ItfERPNotificacao {

    @Override
    public NotificacaoSB gerarNotificacao(TipoNotificacao pTipoNoticacao, ComoUsuario pUsuario, ComoEntidadeSimples pObjeto) throws ErroGerandoNotificacao {
        if (pTipoNoticacao == null) {
            throw new ErroGerandoNotificacao("Tipo de notifcação não pode ser nula");
        }
        if (pUsuario == null) {
            throw new ErroGerandoNotificacao("usuário não é validado");
        }

        NotificacaoSB notificacao = new NotificacaoSB();
        notificacao.setTipoNotificacao(pTipoNoticacao);
        notificacao.setUsuario((UsuarioSB) pUsuario);
        notificacao.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());
        if (pObjeto != null) {
            notificacao.setTipoEntidade(UtilCRCReflexaoObjeto.getClassExtraindoProxy(pObjeto.getClass().getSimpleName()).getSimpleName());
            notificacao.setCodigoEntidadeRelacionada(String.valueOf(pObjeto.getId()));
        }

        ItfRespostaAcaoDoSistema resposta = ModuloNotificacao.notificacaoRegistrar(notificacao);
        if (!resposta.isSucesso()) {
            throw new ErroGerandoNotificacao(resposta.getMensagens().get(0).getMenssagem());
        }
        return (NotificacaoSB) resposta.getRetorno();
    }

    @Override
    public ItfDialogo gerarDialogoByNotificacao(NotificacaoSB pNotificacao) throws ErroGerandoDialogo {
        try {
            if (pNotificacao.getId() == null) {
                throw new ErroGerandoDialogo("O Id da notificação não foi definido");
            }
            DialogoNotificacao dialogo = new DialogoNotificacao(pNotificacao);
            dialogo.setCodigoSelo(String.valueOf(pNotificacao.getId()));

            return dialogo;
        } catch (Throwable ex) {
            throw new ErroGerandoDialogo("Erro Selando Comunicação");
        }

    }

    @Override
    public List<NotificacaoSB> gerarNotificacoes(TipoNotificacao tipo, ComoEntidadeSimples pItem, FabTipoAgenteOrganizacao... pTipoAgentes) throws ErroGerandoNotificacao {
        if (pItem == null) {
            throw new ErroGerandoNotificacao("Impossível notificar sobre item nulo");
        }
        List<NotificacaoSB> notificacoes = new ArrayList<>();
        List<ComoUsuario> usuarios = new ArrayList<>();
        final List<FabTipoAgenteOrganizacao> tipoAgentes = Lists.newArrayList(pTipoAgentes);

        for (ItfCampoInstanciado cp : pItem.getCamposInstanciados()) {
            if (cp.getValor() instanceof ComoUsuario) {
                FabTipoAgenteOrganizacao agente = CarameloCode.getServicoPermissao().getTipoAgente((ComoUsuario) cp.getValor());
                if (tipoAgentes.contains(agente)) {
                    NotificacaoSB nt = gerarNotificacao(tipo, (ComoUsuario) cp.getValor(), pItem);
                    notificacoes.add(nt);
                }
            }
            if (cp.isUmValorEmLista()) {
                Class classeEntidade = MapaObjetosProjetoAtual.getClasseDoObjetoByNome(cp.getNomeClasseAtributoDeclarado());
                if (classeEntidade != null) {
                    if (ComoUsuario.class.isAssignableFrom(classeEntidade)) {
                        List<ComoUsuario> usuariosListAtributo = (List) cp.getValor();
                        for (ComoUsuario usr : usuariosListAtributo) {
                            FabTipoAgenteOrganizacao tipoAgenteUsr = CarameloCode.getServicoPermissao().getTipoAgente((ComoUsuario) cp.getValor());
                            if (tipoAgentes.contains(tipoAgenteUsr)) {
                                NotificacaoSB nt = gerarNotificacao(tipo, usr, pItem);
                                notificacoes.add(nt);
                            }
                        }
                    }
                }

            }
        }

        return notificacoes;
    }

    @Override
    public boolean registrarReciboLeitura(String pCodigoDisparo, String pCodigoLeitura) {
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();

        try {

            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(LogDisparoNotificacao.class, em);
            LogDisparoNotificacao disparo = consulta.addcondicaoCampoIgualA(CPLogDisparoNotificacao.codigoregistroenvio, pCodigoDisparo).getPrimeiroRegistro();
            if (disparo != null) {
                ReciboLeitura novoRecibo = new ReciboLeitura();
                novoRecibo.setDisparo(disparo);
                novoRecibo.setCodigoLeitura(pCodigoLeitura);
                return ModuloNotificacao.reciboResposta(novoRecibo).isSucesso();
            } else {
                return false;
            }
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }

    }

    @Override
    public boolean registrarReciboLeitura(ERPTipoCanalComunicacao pTipoCanal, String pCodigoNotificacao, String codigoLeitura) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, pCodigoNotificacao);
            NotificacaoSB notificacao = consulta.getPrimeiroRegistro();

            if (notificacao != null) {
                ReciboLeitura novoRecebio = new ReciboLeitura();
                novoRecebio.setCodigoLeitura(codigoLeitura);
                Optional<LogDisparoNotificacao> logDisparos = notificacao.getDisparos().stream()
                        .filter(dp -> dp.getTipoTransporte().equals(pTipoCanal)).findFirst();
                if (logDisparos.isPresent()) {
                    novoRecebio.setDisparo(logDisparos.get());
                } else {
                    if (notificacao.getDisparos().isEmpty()) {
                        notificacao.setStatus(FabStatusNotificacao.LIDA.getRegistro());
                        //Marca como lida imperativamente
                        UtilSBPersistencia.mergeRegistro(notificacao);

                        //Caso de notificações sem registro de envios
                        return true;
                    } else {
                        novoRecebio.setDisparo(notificacao.getDisparos().get(0));
                    }
                }
                return ModuloNotificacao.reciboResposta(novoRecebio).isSucesso();
            }
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
        return false;

    }

}
