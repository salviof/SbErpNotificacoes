/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.estrategiaNotificacao;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.FabLogDisparoComunicacao;
import com.google.common.collect.Lists;
import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabTipoEstrategiaMidiaNotificacao implements ItfFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = EstrategiaNotificacao.class, id = 1l, nomeObjeto = "Notificação progressiva")
    PROGRESSIVA,
    @InfoObjetoDaFabrica(classeObjeto = EstrategiaNotificacao.class, id = 1l, nomeObjeto = "Alerta pânico")
    ALERTA_PANICO,
    @InfoObjetoDaFabrica(classeObjeto = EstrategiaNotificacao.class, id = 1l, nomeObjeto = "Insistir no Whatsapp")
    INSISTIR_VIA_WHATSAPP,
    @InfoObjetoDaFabrica(classeObjeto = EstrategiaNotificacao.class, id = 1l, nomeObjeto = "Insistir whatsapp e Emails")
    INSISTIR_VIA_EMAIL_E_WHATSAPP,
    @InfoObjetoDaFabrica(classeObjeto = EstrategiaNotificacao.class, id = 1l, nomeObjeto = "Insistir no mobile")
    INSISTIR_VIA_MOBILE;

    public List<FabLogDisparoComunicacao> getMedias(NotificacaoSB pNotificacao) {

        switch (this) {

            case PROGRESSIVA:
                long notificacoesMatrix = pNotificacao.getDisparos().stream().filter(dsp -> dsp.getTipoTransporte().equals(ERPTipoCanalComunicacao.MATRIX)).count();
                long notificacoesSMS = pNotificacao.getDisparos().stream().filter(dsp -> dsp.getTipoTransporte().equals(ERPTipoCanalComunicacao.MATRIX)).count();
                long notificacoesViaEMail = pNotificacao.getDisparos().stream().filter(dsp -> dsp.getTipoTransporte().equals(ERPTipoCanalComunicacao.MATRIX)).count();
                if (ERPTipoCanalComunicacao.MATRIX.isTipoTransporteImplementado()) {
                    if (notificacoesMatrix >= notificacoesSMS && notificacoesMatrix >= notificacoesViaEMail) {
                        return Lists.newArrayList(FabLogDisparoComunicacao.MATRIX);
                    }
                }

                if (ERPTipoCanalComunicacao.EMAIL.isTipoTransporteImplementado()) {
                    if (notificacoesViaEMail <= notificacoesSMS && notificacoesViaEMail <= notificacoesMatrix) {
                        return Lists.newArrayList(FabLogDisparoComunicacao.EMAIL);
                    }

                }

                if (ERPTipoCanalComunicacao.SMS.isTipoTransporteImplementado()) {
                    if (notificacoesMatrix <= notificacoesMatrix && notificacoesMatrix <= notificacoesViaEMail) {
                        return Lists.newArrayList(FabLogDisparoComunicacao.SMS);
                    }

                }

                return Lists.newArrayList(FabLogDisparoComunicacao.EMAIL);

            case ALERTA_PANICO:
                return Lists.newArrayList(FabLogDisparoComunicacao.EMAIL, FabLogDisparoComunicacao.INTRANET_MENU, FabLogDisparoComunicacao.MATRIX, FabLogDisparoComunicacao.SMS, FabLogDisparoComunicacao.WHATZAUP);

            case INSISTIR_VIA_WHATSAPP:
                return Lists.newArrayList(FabLogDisparoComunicacao.WHATZAUP);

            case INSISTIR_VIA_EMAIL_E_WHATSAPP:
                return Lists.newArrayList(FabLogDisparoComunicacao.WHATZAUP, FabLogDisparoComunicacao.EMAIL);

            case INSISTIR_VIA_MOBILE:
                return Lists.newArrayList(FabLogDisparoComunicacao.MOBILE);

            default:
                return Lists.newArrayList(FabLogDisparoComunicacao.EMAIL);
        }

//        return Lists.newArrayList(FabLogDisparoComunicacao.EMAIL);
    }

}
