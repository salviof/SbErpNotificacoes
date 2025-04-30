package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.reciboentrega;

import br.org.coletivojava.erp.notificacao.padrao.model.recibos.entrega.ReciboEntrega;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ReciboEntrega.class)
public enum CPReciboEntrega {
	_ID, _DISPARO, _CODIGOENTREGA;

	public static final String id = "id";
	public static final String disparo = "disparo";
	public static final String codigoentrega = "codigoEntrega";
}