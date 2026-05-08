package br.org.carameloCode.erp.modulo.notificacao.api.model.reciboleitura;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.recibos.leitura.ReciboLeitura;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = ReciboLeitura.class)
public enum CPReciboLeitura {
	_ID, _DISPARO, _CODIGOLEITURA, _DATAHORALEITURA;

	public static final String id = "id";
	public static final String disparo = "disparo";
	public static final String codigoleitura = "codigoLeitura";
	public static final String datahoraleitura = "dataHoraLeitura";
}