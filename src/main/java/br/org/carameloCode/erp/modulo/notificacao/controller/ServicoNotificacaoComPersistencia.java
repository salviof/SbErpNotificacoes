/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCReflexao;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCReflexaoObjeto;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.CentralComunicaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.Dialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoArmazenamentoComunicacao;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public abstract class ServicoNotificacaoComPersistencia extends CentralComunicaoAbstrato {

    private Map<String, List<TipoNotificacao>> gatilhosDeNotificacao = null;

    @Override
    public ItfDialogo gerarComunicacaoUsuario_Usuario(FabTipoComunicacao tipocomunicacao, ComoUsuario pUsuarioRemetente, ComoUsuario pUsuarioDestinatario, String pAssunto, String mensagem) {

        return super.gerarComunicacaoUsuario_Usuario(tipocomunicacao, pUsuarioRemetente, pUsuarioDestinatario, pAssunto, mensagem);
    }

    @Override
    public ItfDialogo gerarComunicacaoSistema_Usuario(FabTipoComunicacao tipocomunicacao, ComoUsuario pUsuario, String pAssunto, String mensagem) {
        return super.gerarComunicacaoSistema_Usuario(tipocomunicacao, pUsuario, pAssunto, mensagem);
    }

    protected ComoArmazenamentoComunicacao armazenamento;

    public ServicoNotificacaoComPersistencia() {
        armazenamento = new RepositorioComunicacao();
    }

    @Override
    public ComoArmazenamentoComunicacao getArmazenamento() {
        return armazenamento;
    }

    @Override
    public boolean responderComunicacao(String codigoSeloComunicacao, ItfRespostaComunicacao pResposta, final ERPTipoCanalComunicacao pCanal) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {

            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, codigoSeloComunicacao);
            NotificacaoSB ntf = consulta.getPrimeiroRegistro();
            if (ntf != null) {
                if (ntf.getId() != null) {
                    Optional<LogDisparoNotificacao> pesquisadisparo = ntf.getDisparos().stream()
                            .filter(dp -> dp.getTipoTransporte().equals(pCanal)).findFirst();
                    if (pesquisadisparo.isPresent()) {
                        LogDisparoNotificacao disparo = pesquisadisparo.get();
                        return ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().registrarReciboLeitura(disparo.getCodigoRegistroEnvio(), UtilCRCStringGerador.getStringRandomicaUUID());
                    }
                }
            }
            return true;

        } finally {
            UtilSBPersistencia.fecharEM(em);
        }

    }

    @Override
    public List<ItfDialogo> getNotificacoesAtivasMenu() {
        return getArmazenamento().getDialogos(CarameloCode.getServicoSessao().getSessaoAtual().getUsuario(), ERPTipoCanalComunicacao.INTRANET_MENU);
    }

    @Override
    public List<ItfDialogo> getNotificacoesAtivasBloqueioTela() {
        return getArmazenamento().getDialogos(CarameloCode.getServicoSessao().getSessaoAtual().getUsuario(), ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA);
    }

    @Override
    public void atualizarGatilhosDeNotificacaoPorAcao() {
        EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
        try {
            gatilhosDeNotificacao = new ConcurrentHashMap<>();
            ConsultaDinamicaDeEntidade novaconsulta = new ConsultaDinamicaDeEntidade(TipoNotificacao.class, em);

            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TipoNotificacao> cq = cb.createQuery(TipoNotificacao.class);
            Root<TipoNotificacao> root = cq.from(TipoNotificacao.class);
            cq.select(root)
                    .where(cb.isNotNull(root.get("nomeFabricaGatilhoNoticao")));
            List<TipoNotificacao> lista = em.createQuery(cq).getResultList();
            for (TipoNotificacao tp : lista) {
                if (tp.getNomeFabricaGatilhoNoticao() != null && !tp.getNomeFabricaGatilhoNoticao().isEmpty()) {
                    ComoAcaoDoSistema acao = MapaAcoesSistema
                            .getAcaoDoSistemaByNomeUnico(tp.getNomeFabricaGatilhoNoticao());
                    if (acao != null) {
                        if (!gatilhosDeNotificacao.containsKey(tp.getNomeFabricaGatilhoNoticao())) {
                            gatilhosDeNotificacao.put(tp.getNomeFabricaGatilhoNoticao(), new ArrayList<>());
                        }
                        gatilhosDeNotificacao.get(tp.getNomeFabricaGatilhoNoticao()).add(tp);
                    }
                }
            }
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
    }

    @Override
    public List<ItfDialogo> dispararNotificacaoAcaoSucesso(ComoAcaoDoSistema pAcao, ComoEntidadeSimples pEntidadeRetorno) {

        if (gatilhosDeNotificacao == null) {
            atualizarGatilhosDeNotificacaoPorAcao();
        }

        if (!gatilhosDeNotificacao.containsKey(pAcao.getEnumAcaoDoSistema().getNomeUnico())) {
            return null;
        }
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ComoEntidadeSimples entidadeRelacionda = null;

            List<TipoNotificacao> tiposNTF = gatilhosDeNotificacao.get(pAcao.getEnumAcaoDoSistema().getNomeUnico());
            for (TipoNotificacao tipo : tiposNTF) {

                if (pEntidadeRetorno != null) {
                    Class classeRetorno = (UtilCRCReflexaoObjeto.getClassExtraindoProxy(pEntidadeRetorno.getClass().getSimpleName()));
                    if (classeRetorno.getSimpleName().equals(tipo.getNomeEntidadeReferencia())) {
                        entidadeRelacionda = UtilSBPersistencia.loadEntidade(pEntidadeRetorno, em);
                    } else {
                        entidadeRelacionda = null;
                    }
                }
                if (entidadeRelacionda != null) {
                    try {
                        List<NotificacaoSB> notificacoes = ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().gerarNotificacoes(tipo, entidadeRelacionda);
                        List<ItfDialogo> dialogos = new ArrayList<>();
                        notificacoes.stream().map(ntf -> ntf.getDialogo()).forEach(dialogos::add);
                        return dialogos;
                    } catch (ErroGerandoNotificacao ex) {
                        CarameloCode.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha gerando notificação", ex);
                    }
                }

                switch (tipo.getTipoAgente()) {

                    default:
                        throw new AssertionError();
                }

            }
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
        return null;

    }

}
