package br.org.carameloCode.erp.modulo.notificacao.api.model.statusnotificacao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.StatusNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = StatusNotificacao.class)
public enum CPStatusNotificacao {
	_ID, _NOME, _ICONE, _COR, _STATUSENUM;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String icone = "icone";
	public static final String cor = "cor";
	public static final String statusenum = "statusEnum";
}