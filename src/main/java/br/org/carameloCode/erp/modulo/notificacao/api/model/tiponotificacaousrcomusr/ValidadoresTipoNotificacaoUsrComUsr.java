package br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacaoUsrComUsr.class)
public enum ValidadoresTipoNotificacaoUsrComUsr {
	NOME, ACAOGATILHONOTIFICACAO, ACAORESPOSTAPERSONALIZADA, NOTIFICARVIAMATRIX, NOTIFICARVIAMENU, NOTIFICARVIATELADEBLOQUEIO, NOTIFICARVIAMOBILE, NOTIFICARVIAWHATSAPP, NOTIFICARVIAAPIPERSONALIZADA, NOTIFICARVIASMS, NOTIFICARVIAEMAIL, CAMINHOUSUARIODESTINATARIO, ESTRUTURAENTIDADE
}