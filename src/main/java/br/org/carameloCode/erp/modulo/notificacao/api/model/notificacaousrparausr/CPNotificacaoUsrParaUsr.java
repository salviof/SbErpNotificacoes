package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoUsrParaUsr.class)
public enum CPNotificacaoUsrParaUsr {
	_USUARIOAGUARDANDORESPOSTA, _TEXTORESPOSTAAOREMETENTE, _OBSERVACAO, _ACAOPERMISSAOUSOUNICO;

	public static final String usuarioaguardandoresposta = "usuarioAguardandoResposta";
	public static final String textorespostaaoremetente = "textoRespostaAoRemetente";
	public static final String observacao = "observacao";
	public static final String acaopermissaousounico = "acaoPermissaoUsoUnico";
}