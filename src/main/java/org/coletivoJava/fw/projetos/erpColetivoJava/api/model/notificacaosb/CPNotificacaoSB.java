package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = NotificacaoSB.class)
public enum CPNotificacaoSB {
	_ID, _NOME, _TIPOENTIDADE, _ASSUNTO, _CONTEUDOHTML, _USUARIO, _TIPONOTIFICACAO, _STATUS, _DATAREGISTRONOTIFICACAO, _DATAEXPIRANOTIFICACAO, _DISPAROS, _CODIGOSELOCOMUNICACAO, _CODIGOENTIDADERELACIONADA, _DIALOGO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String tipoentidade = "tipoEntidade";
	public static final String assunto = "assunto";
	public static final String conteudohtml = "conteudoHtml";
	public static final String usuario = "usuario";
	public static final String tiponotificacao = "tipoNotificacao";
	public static final String status = "status";
	public static final String dataregistronotificacao = "dataRegistroNotificacao";
	public static final String dataexpiranotificacao = "dataExpiraNotificacao";
	public static final String disparos = "disparos";
	public static final String codigoselocomunicacao = "codigoSeloComunicacao";
	public static final String codigoentidaderelacionada = "codigoEntidadeRelacionada";
	public static final String dialogo = "dialogo";
}