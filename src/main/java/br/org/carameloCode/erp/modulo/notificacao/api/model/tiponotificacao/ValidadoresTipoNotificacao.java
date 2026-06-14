package br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacao.class)
public enum ValidadoresTipoNotificacao {
	NOME, ACAOGATILHONOTIFICACAO, NOTIFIFICARVIAMATRIX, NOTIFICARVIAMENU, NOTIFICARVIATELADEBLOQUEIO, NOTIFICARVIAMOBILE, NOTIFICARVIAWHATSAPP, NOTIFICARVIAAPIPERSONALIZADA, NOTIFICARVIASMS, NOTIFICARVIAEMAIL, CAMINHOUSUARIODESTINATARIO, ESTRUTURAENTIDADE
}