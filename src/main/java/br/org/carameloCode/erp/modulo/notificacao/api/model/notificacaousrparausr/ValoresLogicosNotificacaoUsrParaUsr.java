package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoUsrParaUsr.class)
public enum ValoresLogicosNotificacaoUsrParaUsr {
	ASSUNTO, CONTEUDOHTML
}