package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.transportenotificacao;

import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = LogDisparoNotificacao.class)
public enum CPTransporteNotificacao {
	_ID, _NOTIFICACAO, _TIPOTRANSPORTE, _FOIENVIADO, _FOILIDO, _RECIBOENTREGA, _RECIBOLEITURA;

	public static final String id = "id";
	public static final String notificacao = "notificacao";
	public static final String tipotransporte = "tipoTransporte";
	public static final String foienviado = "foiEnviado";
	public static final String foilido = "foiLido";
	public static final String reciboentrega = "reciboEntrega";
	public static final String reciboleitura = "reciboLeitura";
}