package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValorLogicoTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValoresLogicosTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacaoUsrComUsr(calculo = ValoresLogicosTipoNotificacaoUsrComUsr.ACAOGATILHONOTIFICACAO)
public class ValorLogicoTipoNotificacaoUsrComUsrAcaoGatilhoNotificacao
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoTipoNotificacaoUsrComUsrAcaoGatilhoNotificacao(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public TipoNotificacaoUsrComUsr getTipoNotificacaoUsrComUsr() {
		return (TipoNotificacaoUsrComUsr) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}