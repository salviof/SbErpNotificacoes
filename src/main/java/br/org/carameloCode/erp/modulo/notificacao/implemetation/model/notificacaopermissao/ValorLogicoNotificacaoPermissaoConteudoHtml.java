package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaopermissao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaopermissao.ValorLogicoNotificacaoPermissao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaopermissao.ValoresLogicosNotificacaoPermissao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoPermissao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoPermissao(calculo = ValoresLogicosNotificacaoPermissao.CONTEUDOHTML)
public class ValorLogicoNotificacaoPermissaoConteudoHtml
		extends
			ValorLogicoCalculoGenerico {

	public ValorLogicoNotificacaoPermissaoConteudoHtml(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	public NotificacaoPermissao getNotificacaoPermissao() {
		return (NotificacaoPermissao) getCampoInst().getObjetoRaizDoAtributo();
	}
}