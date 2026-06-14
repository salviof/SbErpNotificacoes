package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaopermissao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoPermissao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoPermissao.class)
public enum CPNotificacaoPermissao {
	_ACAOPERMITIDA;

	public static final String acaopermitida = "acaoPermitida";
}