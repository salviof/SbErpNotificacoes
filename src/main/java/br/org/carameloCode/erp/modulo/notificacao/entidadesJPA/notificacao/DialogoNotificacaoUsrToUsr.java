/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogoEntrePessoas;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

/**
 *
 * @author salvio
 */
public class DialogoNotificacaoUsrToUsr extends DialogoNotificacao implements ItfDialogoEntrePessoas {

    private ComoUsuario usuarioRemetente;
    private boolean remetenteAguardandoResposta;
    private String observacao;
    private String respostaPositva;
    private String repostaNegativa;

    public DialogoNotificacaoUsrToUsr(NotificacaoUsrParaUsr pNotificacao) {
        super(pNotificacao);
        usuarioRemetente = pNotificacao.getUsuarioAguardandoResposta();
        remetenteAguardandoResposta = pNotificacao.getTipoNotificacao().isExigirReciboDeEntrega();
        observacao = pNotificacao.getObservacao();
        respostaPositva = pNotificacao.getTipoNotificacao().getComoTiponotificacaoUsrToUsr().getTextoRespostaPositivo();
        repostaNegativa = pNotificacao.getTipoNotificacao().getComoTiponotificacaoUsrToUsr().getTextoRespostaNegativo();

    }

    @Override
    public ComoUsuario getUsuarioRemetente() {
        return usuarioRemetente;
    }

    @Override
    public boolean isRemetenteAguardandoReposta() {
        return remetenteAguardandoResposta;
    }

    @Override
    public String getObservacaoResposta() {
        return observacao;
    }

    @Override
    public String getTextoRespostaPositivaAoRemetente() {
        return respostaPositva;
    }

    @Override
    public String getTextoRespostaNegativaAoRemetente() {
        return repostaNegativa;
    }

}
