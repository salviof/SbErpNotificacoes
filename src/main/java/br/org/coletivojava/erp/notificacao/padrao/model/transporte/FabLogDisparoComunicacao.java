/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.transporte;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;

/**
 *
 * @author salvio
 */
public enum FabLogDisparoComunicacao {

    EMAIL,
    SMS,
    INTRANET_MENU,
    INTRANET_MODAL,
    API_PERSONALIZADA,
    WHATZAUP,
    MATRIX,
    MOBILE;

    public LogDisparoNotificacao getRegistro(NotificacaoSB pNotificacao) {
        LogDisparoNotificacao logDisparo = new LogDisparoNotificacao();
        logDisparo.setNotificacao(pNotificacao);
        logDisparo.setTipoTransporte(getTRansporte());
        logDisparo.setFoiEnviado(false);
        return logDisparo;
    }

    public ERPTipoCanalComunicacao getTRansporte() {
        switch (this) {

            case EMAIL:
                return ERPTipoCanalComunicacao.EMAIL;
            case SMS:
                return ERPTipoCanalComunicacao.SMS;
            case INTRANET_MENU:
                return ERPTipoCanalComunicacao.INTRANET_MENU;
            case INTRANET_MODAL:
                return ERPTipoCanalComunicacao.INTRANET_MODAL;
            case API_PERSONALIZADA:
                return ERPTipoCanalComunicacao.API_PERSONALIZADA;
            case WHATZAUP:
                return ERPTipoCanalComunicacao.WHATZAUP;
            case MATRIX:
                return ERPTipoCanalComunicacao.MATRIX;
            case MOBILE:
                return ERPTipoCanalComunicacao.MOBILE;
            default:
                throw new AssertionError();
        }
    }

    public boolean isMarcadoParaNotificar(TipoNotificacao tipoNotificacao) {
        switch (this) {

            case EMAIL:
                return tipoNotificacao.isNotificarViaEmail();

            case SMS:
                return tipoNotificacao.isNotificarViaEmail();
            case INTRANET_MENU:
                return tipoNotificacao.isNotificarViaIntranet();
            case INTRANET_MODAL:
                return tipoNotificacao.isNotificarViaIntranet();
            case API_PERSONALIZADA:
                return tipoNotificacao.isNotificarViaApiPersonalizada();
            case WHATZAUP:
                return tipoNotificacao.isNotificarViaWhatsapp();
            case MATRIX:
                return tipoNotificacao.isNotifificarViaMatrix();
            case MOBILE:
                return tipoNotificacao.isNotificarViaMobile();
            default:
                throw new AssertionError();
        }
    }

}
