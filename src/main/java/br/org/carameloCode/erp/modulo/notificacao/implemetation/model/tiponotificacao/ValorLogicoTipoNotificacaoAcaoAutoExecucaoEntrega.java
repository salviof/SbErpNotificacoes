package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAOAUTOEXECUCAOENTREGA)
public class ValorLogicoTipoNotificacaoAcaoAutoExecucaoEntrega
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoTipoNotificacaoAcaoAutoExecucaoEntrega(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public TipoNotificacao getTipoNotificacao() {
		return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
	}
}