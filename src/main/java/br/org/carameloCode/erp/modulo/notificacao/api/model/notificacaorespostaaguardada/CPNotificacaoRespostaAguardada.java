package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoRespostaAguardada.class)
public enum CPNotificacaoRespostaAguardada {
	_NOTIFICACAOORIGEM;

	public static final String notificacaoorigem = "notificacaoOrigem";
}