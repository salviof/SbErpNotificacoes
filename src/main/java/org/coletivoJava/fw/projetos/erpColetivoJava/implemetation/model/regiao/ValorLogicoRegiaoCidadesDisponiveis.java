package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.regiao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.regiao.ValorLogicoRegiao;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.regiao.ValoresLogicosRegiao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoRegiao(calculo = ValoresLogicosRegiao.CIDADESDISPONIVEIS)
public class ValorLogicoRegiaoCidadesDisponiveis
		extends
			ValorLogicoCalculoGenerico {

	ValorLogicoRegiaoCidadesDisponiveis(ItfCampoInstanciado pCampo) {
		super(pCampo);
	}
}