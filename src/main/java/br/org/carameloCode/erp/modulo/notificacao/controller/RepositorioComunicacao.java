/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.DialogoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ArmazenamentoComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public class RepositorioComunicacao extends ArmazenamentoComunicacaoTransient {

    @Override
    protected Map<String, ItfDialogo> getComunicacoesAtivas() {
        Map<String, ItfDialogo> comunicacoesAtivas = super.getComunicacoesAtivas();
        if (comunicacoesAtivas.isEmpty()) {
            EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
            try {
                ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
                consulta.addCondicaoManyToOneIgualA(CPNotificacaoSB.status, FabStatusNotificacao.ENVIADA.getRegistro());
                List<NotificacaoSB> notificacoes = consulta.gerarResultados();

                for (NotificacaoSB ntf : notificacoes) {
                    if (ntf.getDisparos().stream().filter(dp -> dp.getTipoTransporte().equals(ERPTipoCanalComunicacao.INTRANET_MENU)).findFirst().isPresent()) {
                        DialogoNotificacao dialogo = new DialogoNotificacao(ntf);
                        dialogo.setCodigoSelo(String.valueOf(ntf.getCodigoSeloComunicacao()));
                        comunicacoesAtivas.put(ntf.getCodigoSeloComunicacao(), dialogo);

                    }
                }
            } finally {
                UtilSBPersistencia.fecharEM(em);
            }
        }
        return super.getComunicacoesAtivas();
    }

    @Override
    public ItfDialogo getDialogoByCodigoSelo(String pCodigoSelo) {
        ItfDialogo dialogo = super.getDialogoByCodigoSelo(pCodigoSelo);
        if (dialogo != null) {
            return dialogo;
        }
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, pCodigoSelo);
            NotificacaoSB nt = consulta.getPrimeiroRegistro();
            if (nt != null) {

                dialogo = new DialogoNotificacao(nt);
                dialogo.setCodigoSelo(String.valueOf(nt.getId()));
                getComunicacoesAtivas().put(pCodigoSelo, dialogo);
                /// PROBLEMA NO GETdIALOGO CHAMA  getDialogoByCodigoSelo NOVAMENTE, GERANDO LOOP
                /// nt.getDialogo();
                ///
                //dialogo = SBCore.getServicoComunicacao().registrarDialogo(nt.getCodigoSeloComunicacao(), nt.getDialogo());

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
    public boolean registrarDialogo(ItfDialogo pComunicacao) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, pComunicacao.getCodigoSelo());
            consulta.getPrimeiroRegistro();

            NotificacaoSB nt = consulta.getPrimeiroRegistro();

            Optional<LogDisparoNotificacao> disparoMenu = nt.getDisparos().stream().filter(dp -> dp.getTipoTransporte().equals(ERPTipoCanalComunicacao.INTRANET_MENU.getRegistro())).findFirst();

            if (disparoMenu.isPresent()) {

            } else {

            }
        } finally {

        }
        return super.registrarDialogo(pComunicacao); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override

    public List<ItfDialogo> getComunicacoesAguardandoRespostaDoDestinatario(ComoUsuario pDestinatario
    ) {
        return super.getComunicacoesAguardandoRespostaDoDestinatario(pDestinatario); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public List<ItfDialogo> getComunicacoesAguardandoRespostaDoRemetente(ComoUsuario pRemetente
    ) {
        return super.getComunicacoesAguardandoRespostaDoRemetente(pRemetente); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
