package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAOGATILHONOTIFICACAO)
public class ValorLogicoTipoNotificacaoAcaoGatilhoNotificacao
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoTipoNotificacaoAcaoGatilhoNotificacao(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {
        if (getTipoNotificacao().getNomeFabricaGatilhoNoticao() != null && !getTipoNotificacao().getNomeFabricaGatilhoNoticao().isEmpty()) {
            getTipoNotificacao().setAcaoGatilhoNotificacao((AcaoDoSistema) MapaAcoesSistema.getAcaoDoSistemaByNomeUnico(getTipoNotificacao().getNomeFabricaGatilhoNoticao()));
        }
        return getTipoNotificacao().getAcaoGatilhoNotificacao();
    }

    public TipoNotificacao getTipoNotificacao() {
        return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
    }
}
