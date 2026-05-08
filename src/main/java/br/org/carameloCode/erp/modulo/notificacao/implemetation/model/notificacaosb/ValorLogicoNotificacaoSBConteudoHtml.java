package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb;

import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.ValorLogicoNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoSB(calculo = ValoresLogicosNotificacaoSB.CONTEUDOHTML)
public class ValorLogicoNotificacaoSBConteudoHtml
        extends ValorLogicoNotificacaoPalavrasChave {

    public ValorLogicoNotificacaoSBConteudoHtml(ItfCampoInstanciado pCampo) {
        super(pCampo, ((NotificacaoSB) pCampo.getObjetoRaizDoAtributo()).getTipoNotificacao().getConteudoHTML());
    }

    @Override
    public Object getValor(Object... pEntidade) {
        if (getNotificacao().getConteudoHtml() == null) {
            String valor = (String) super.getValor(pEntidade);
            getNotificacao().setConteudoHtml(valor);
        }

        return getNotificacao().getConteudoHtml();
    }

    public NotificacaoSB getNotificacao() {
        return (NotificacaoSB) getCampoInst().getObjetoRaizDoAtributo();
    }

}
