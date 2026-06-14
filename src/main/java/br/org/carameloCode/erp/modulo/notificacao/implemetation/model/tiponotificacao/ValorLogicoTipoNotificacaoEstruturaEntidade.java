package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ESTRUTURAENTIDADE)
public class ValorLogicoTipoNotificacaoEstruturaEntidade
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoTipoNotificacaoEstruturaEntidade(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {
        if (getTipoNotificacao().getNomeEntidadeReferencia() != null) {
            EstruturaDeEntidade est = MapaObjetosProjetoAtual.getEstruturaObjeto(getTipoNotificacao().getNomeEntidadeReferencia());
            getTipoNotificacao().setEstruturaEntidade(est);
        }
        return getTipoNotificacao().getEstruturaEntidade();
    }

    public TipoNotificacao getTipoNotificacao() {
        return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
    }
}
