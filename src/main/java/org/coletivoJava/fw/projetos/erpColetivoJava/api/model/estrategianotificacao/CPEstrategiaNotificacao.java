package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.estrategianotificacao;

import br.org.coletivojava.erp.notificacao.padrao.model.estrategiaNotificacao.EstrategiaNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = EstrategiaNotificacao.class)
public enum CPEstrategiaNotificacao {
	_ID, _NOME, _DESCRICAO;

	public static final String id = "id";
	public static final String nome = "nome";
	public static final String descricao = "descricao";
}