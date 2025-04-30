package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.reciboleitura;

import br.org.coletivojava.erp.notificacao.padrao.model.recibos.leitura.ReciboLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ReciboLeitura.class)
public enum CPReciboLeitura {
	_ID, _DISPARO, _CODIGOLEITURA, _DATAHORALEITURA;

	public static final String id = "id";
	public static final String disparo = "disparo";
	public static final String codigoleitura = "codigoLeitura";
	public static final String datahoraleitura = "dataHoraLeitura";
}