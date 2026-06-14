package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.ArrayList;
import java.util.List;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ACAOESGATILHODISPONIVEIS)
public class ValorLogicoTipoNotificacaoAcaoesGatilhoDisponiveis
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoTipoNotificacaoAcaoesGatilhoDisponiveis(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {

        if (getTipoNotificacao().getAcaoesGatilhoDisponiveis() == null || getTipoNotificacao().getAcoesDisponiveis().isEmpty()) {
            List<ComoAcaoDoSistema> acoes = new ArrayList<>();
            MapaAcoesSistema.getListaTodasAcoes().stream().filter(ac -> ac.isUmaAcaoController()).forEach(acoes::add);
            getTipoNotificacao().setAcaoesGatilhoDisponiveis((List) acoes);

        }
        return getTipoNotificacao().getAcaoesGatilhoDisponiveis();
    }

    public TipoNotificacao getTipoNotificacao() {
        return (TipoNotificacao) getCampoInst().getObjetoRaizDoAtributo();
    }
}
