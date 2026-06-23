/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogoEntrePessoas;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItffabricaCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.dialogo.resposta.RespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoServicoComunicacao;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author salvio
 */
public class ServicoNotificacaoPadraoDev extends
        ServicoNotificacaoComPersistencia implements ComoServicoComunicacao {

    public ServicoNotificacaoPadraoDev() {
        super();
    }

    @Override
    public FabTipoRespostaComunicacao aguardarRespostaComunicacao(ItfTipoCanalComunicacao pTransporte,
            ComoDialogo pComunicacao, int tempoAguardar, FabTipoRespostaComunicacao pTipoRespostaTempoFinal) {
        FabTipoComunicacao tipocomunicacao = pComunicacao.getTipoComunicacao().getFabTipoComunicacao();

        int dialogResult
                = JOptionPane.showConfirmDialog(null, pComunicacao.getMensagem(),
                        "Deseja continuar?", JOptionPane.YES_OPTION);
        if (dialogResult
                == JOptionPane.YES_OPTION) {
            return FabTipoRespostaComunicacao.SIM;
        } else {
            System.out.println("não");
            return FabTipoRespostaComunicacao.NAO;
        }

    }

    @Override
    public String getTokenDispositivoNotificacao(ComoUsuario pUsuario) {
        return null;
    }

    @Override
    public ItffabricaCanalComunicacao getCanalPadrao() {
        return ERPTipoCanalComunicacao.INTRANET_MENU;
    }

    @Override
    public boolean notificarViaMenu(ComoDialogo pDialogo) {

        System.out.println("Aicionado notificacao no menu");
        System.out.println(pDialogo.getMensagem());
        System.out.println(pDialogo.getAssunto());
        return true;
    }

    @Override
    public boolean notificarViaBloqueioTEla(ComoDialogo pDialogo) {
        if (JOptionPane.showConfirmDialog(null, pDialogo.getMensagem(),
                "Deseja continuar?", JOptionPane.YES_OPTION) == 0) {

            return responderComunicacao(pDialogo.getCodigoSelo(), new RespostaComunicacao(pDialogo, FabTipoRespostaComunicacao.ENTENDIDO.getRegistro()), ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA);
        }
        return false;
    }

    @Override
    public List<ComoDialogoEntrePessoas> getMsgColaboradorAguarandoMinhaResposta() {
        return getArmazenamento().getMensagemAguardandoMinhaResposta(CarameloCode.getUsuarioLogado(), ERPTipoCanalComunicacao.INTRANET_MENU);
    }

}
