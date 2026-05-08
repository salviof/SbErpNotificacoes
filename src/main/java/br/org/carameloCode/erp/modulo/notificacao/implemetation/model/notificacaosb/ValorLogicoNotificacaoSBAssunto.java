package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb;

import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.ValorLogicoNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoSB(calculo = ValoresLogicosNotificacaoSB.ASSUNTO)
public class ValorLogicoNotificacaoSBAssunto extends ValorLogicoNotificacaoPalavrasChave {

    public ValorLogicoNotificacaoSBAssunto(ItfCampoInstanciado pCampo) {
        super(pCampo, ((NotificacaoSB) pCampo.getObjetoRaizDoAtributo()).getTipoNotificacao().getAssunto());
    }

    @Override
    public Object getValor(Object... pEntidade) {
        if (getNotificacao().getAssunto() == null) {
            String valor = (String) super.getValor(pEntidade);
            getNotificacao().setAssunto(valor);
        }
        return getNotificacao().getAssunto();
    }

    public NotificacaoSB getNotificacao() {
        return (NotificacaoSB) getCampoInst().getObjetoRaizDoAtributo();
    }
}
