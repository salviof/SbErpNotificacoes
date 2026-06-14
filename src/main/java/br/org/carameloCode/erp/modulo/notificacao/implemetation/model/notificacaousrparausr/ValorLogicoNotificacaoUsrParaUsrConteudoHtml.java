package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaousrparausr;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr.ValorLogicoNotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr.ValoresLogicosNotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoUsrParaUsr(calculo = ValoresLogicosNotificacaoUsrParaUsr.CONTEUDOHTML)
public class ValorLogicoNotificacaoUsrParaUsrConteudoHtml
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoNotificacaoUsrParaUsrConteudoHtml(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public NotificacaoUsrParaUsr getNotificacaoUsrParaUsr() {
		return (NotificacaoUsrParaUsr) getCampoInst().getObjetoRaizDoAtributo();
	}
}