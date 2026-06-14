package br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacaoUsrComUsr.class)
public enum ValoresLogicosTipoNotificacaoUsrComUsr {
	NOME, ACAOGATILHONOTIFICACAO, ACAOAUTOEXECUCAOENVIO, ACAOAUTOEXECUCAOENTREGA, ACAOAUTOEXECUCAOLEITURA, ESTRUTURAENTIDADE, ACAOESGATILHODISPONIVEIS, ENTIDADESDISPONIVEIS
}