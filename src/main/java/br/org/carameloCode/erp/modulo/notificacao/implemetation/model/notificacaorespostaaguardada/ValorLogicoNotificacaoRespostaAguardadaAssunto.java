package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaorespostaaguardada;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValorLogicoNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValoresLogicosNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoRespostaAguardada(calculo = ValoresLogicosNotificacaoRespostaAguardada.ASSUNTO)
public class ValorLogicoNotificacaoRespostaAguardadaAssunto
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoNotificacaoRespostaAguardadaAssunto(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public NotificacaoRespostaAguardada getNotificacaoRespostaAguardada() {
		return (NotificacaoRespostaAguardada) getCampoInst()
				.getObjetoRaizDoAtributo();
	}
}