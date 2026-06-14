package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAOAUTOEXECUCAOLEITURA)
public class ValorLogicoTipoNotificacaoAcaoAutoExecucaoLeitura
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoTipoNotificacaoAcaoAutoExecucaoLeitura(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public TipoNotificacao getTipoNotificacao() {
		return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
	}
}