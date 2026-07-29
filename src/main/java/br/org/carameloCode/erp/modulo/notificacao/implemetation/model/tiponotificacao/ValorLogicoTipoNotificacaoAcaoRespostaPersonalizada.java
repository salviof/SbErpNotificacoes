package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAORESPOSTAPERSONALIZADA)
public class ValorLogicoTipoNotificacaoAcaoRespostaPersonalizada
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoTipoNotificacaoAcaoRespostaPersonalizada(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {

        if (getTipoNotificacao().getNomeFabricaGatilhoAcaoEntrega() != null) {

        }

        if (getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada() != null && !getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada().isEmpty()) {
            getTipoNotificacao().setAcaoGatilhoNotificacao((AcaoDoSistema) MapaAcoesSistema.getAcaoDoSistemaByNomeUnico(getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada()));
        }
        return getTipoNotificacao().getAcaoRespostaPersonalizada();
    }

    public TipoNotificacao getTipoNotificacao() {
        return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
    }
}
