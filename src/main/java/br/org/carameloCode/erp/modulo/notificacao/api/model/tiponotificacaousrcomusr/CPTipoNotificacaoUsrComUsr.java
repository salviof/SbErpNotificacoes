package br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacaoUsrComUsr.class)
public enum CPTipoNotificacaoUsrComUsr {
	_CAMINHOUSUARIOREMETENTE, _NOTIFICARDESTINATARIO, _TEXTORESPOSTAPOSITIVO, _TEXTORESPOSTANEGATIVO;

	public static final String caminhousuarioremetente = "caminhoUsuarioRemetente";
	public static final String notificardestinatario = "notificarDestinatario";
	public static final String textorespostapositivo = "textoRespostaPositivo";
	public static final String textorespostanegativo = "textoRespostaNegativo";
}