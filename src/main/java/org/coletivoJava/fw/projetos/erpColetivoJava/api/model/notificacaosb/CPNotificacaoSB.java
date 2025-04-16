package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoSB.class)
public enum CPNotificacaoSB {
	_ID, _TIPOENTIDADE, _CONTEUDO, _CONTEUDOHTML, _USUARIO, _TIPONOTIFICACAO, _STATUS, _DATAENVIONOTIFICACAO, _DATAEXPIRANOTIFICACAO, _DATAENTREGANOTIFICACAO, _DATACONFIRMACAOLEITURA, _DISPAROS;

	public static final String id = "id";
	public static final String tipoentidade = "tipoEntidade";
	public static final String conteudo = "conteudo";
	public static final String conteudohtml = "conteudoHtml";
	public static final String usuario = "usuario";
	public static final String tiponotificacao = "tipoNotificacao";
	public static final String status = "status";
	public static final String dataenvionotificacao = "dataEnvioNotificacao";
	public static final String dataexpiranotificacao = "dataExpiraNotificacao";
	public static final String dataentreganotificacao = "dataEntregaNotificacao";
	public static final String dataconfirmacaoleitura = "dataConfirmacaoLeitura";
	public static final String disparos = "disparos";
}