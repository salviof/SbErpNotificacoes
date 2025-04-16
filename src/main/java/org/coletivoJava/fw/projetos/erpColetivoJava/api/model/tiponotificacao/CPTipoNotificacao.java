package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao;

import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacao.class)
public enum CPTipoNotificacao {
	_ID, _TIPOENTIDADE, _NOME, _ASSUNTO, _CONTEUDO, _CONTEUDOHTML;

	public static final String id = "id";
	public static final String tipoentidade = "tipoEntidade";
	public static final String nome = "nome";
	public static final String assunto = "assunto";
	public static final String conteudo = "conteudo";
	public static final String conteudohtml = "conteudoHTML";
}