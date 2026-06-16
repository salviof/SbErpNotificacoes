package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValorLogicoTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValoresLogicosTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValorLogicoTipoNotificacaoNome;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacaoUsrComUsr(calculo = ValoresLogicosTipoNotificacaoUsrComUsr.NOME)
public class ValorLogicoTipoNotificacaoUsrComUsrNome
        extends
        ValorLogicoTipoNotificacaoNome {

    public ValorLogicoTipoNotificacaoUsrComUsrNome(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public TipoNotificacaoUsrComUsr getTipoNotificacaoUsrComUsr() {
        return (TipoNotificacaoUsrComUsr) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
