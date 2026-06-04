package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoDialogo;
import br.org.carameloCode.erp.modulo.notificacao.api.ItfERPNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ArmazenamentoComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public class RepositorioComunicacao extends ArmazenamentoComunicacaoTransient {

    @Override
    protected Map<String, ItfDialogo> getComunicacoesAtivas() {
        Map<String, ItfDialogo> comunicacoesAtivas = super.getComunicacoesAtivas();
        ItfERPNotificacao servicoNotificacao = CarameloCode.getServicoERP(ERPNotificacoes.NOTIFICACAO_PADRAO);
        if (comunicacoesAtivas.isEmpty()) {
            EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
            try {
                ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
                consulta.addCondicaoManyToOneIgualA(CPNotificacaoSB.status, FabStatusNotificacao.ENVIADA.getRegistro());
                List<NotificacaoSB> notificacoes = consulta.gerarResultados();

                for (NotificacaoSB ntf : notificacoes) {
                    try {
                        comunicacoesAtivas.put(ntf.getCodigoSeloComunicacao(), servicoNotificacao.gerarDialogoByNotificacao(ntf));
                    } catch (ErroGerandoDialogo ex) {
                        SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha criando notificação inválida", ex);
                    }

                }
            } finally {
                UtilSBPersistencia.fecharEM(em);
            }
        }
        return super.getComunicacoesAtivas();
    }

    protected List<ItfDialogo> getComunicacoesAtivas(UsuarioSB pUsuario, ERPTipoCanalComunicacao pTipoComunicacao) {
        //TODO: Não precisa consultar o banco, se esse método for frequente, usar um for em comunicações ativas vale mais a Pena
        List<ItfDialogo> dialogos = new ArrayList<>();
        getComunicacoesAtivas().values().stream().filter(cm -> cm.getDestinatario() != null && cm.getDestinatario().getUsuario().equals(pUsuario))
                .filter(dlgtp -> dlgtp.getCanais().contains(pTipoComunicacao))
                .forEach(dialogos::add);

//
        //   String jpql = "SELECT DISTINCT n.id         "
        //            + "FROM NotificacaoSB n     JOIN n.disparos d   "
        //            + "WHERE n.id IN :ids  AND d.tipoTransporte = :tipoTransporte AND n.status_id = " + FabStatusNotificacao.ENVIADA.getRegistro().getId()
        //            + " AND n.usuario = :usuario";
        //    EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        //     TypedQuery<Long> query = em.createQuery(jpql, Long.class);
//        query.setParameter("ids", codigosDecomunicao);
        //      query.setParameter("tipoTransporte", pTipoComunicacao);
        //       query.setParameter("usuario", pUsuario);
        //      List<NotificacaoSB> notificacoesDoTipo = (List) query.getResultList();
        //      for (NotificacaoSB ntf : notificacoesDoTipo) {
        //         comunicacaoAtivaComFiltro.put(ntf.getCodigoSeloComunicacao(), ntf.getDialogo());
        //           registrarDialogoAtivo(ntf.getDialogo());
        //     }
        return dialogos;
    }

    @Override
    public ItfDialogo getDialogoAtivoByCodigoSelo(String pCodigoSelo) {
        ItfDialogo dialogo = super.getDialogoAtivoByCodigoSelo(pCodigoSelo);
        if (dialogo != null) {
            return dialogo;
        }
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, pCodigoSelo);
            NotificacaoSB nt = consulta.getPrimeiroRegistro();
            if (nt != null) {

                dialogo = ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().gerarDialogoByNotificacao(nt);

                //  getComunicacoesAtivas().put(pCodigoSelo, dialogo);
                /// PROBLEMA NO GETdIALOGO CHAMA  getDialogoByCodigoSelo NOVAMENTE, GERANDO LOOP
                /// nt.getDialogo();
                ///
                //dialogo = SBCore.getServicoComunicacao().registrarDialogoAtivo(nt.getCodigoSeloComunicacao(), nt.getDialogo());

                return dialogo;

            } else {
                return null;
            }

        } catch (Throwable ex) {
            return null;
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
    }

    @Override
    public boolean registrarDialogoAtivo(ItfDialogo pComunicacao) {

        return super.registrarDialogoAtivo(pComunicacao);
    }

}
