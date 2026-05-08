package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoSB.class)
public enum ValoresLogicosNotificacaoSB {
	ASSUNTO, CONTEUDOHTML
}