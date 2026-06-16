package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaorespostaaguardada;

import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValorLogicoNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValoresLogicosNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb.ValorLogicoNotificacaoSBAssunto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoRespostaAguardada(calculo = ValoresLogicosNotificacaoRespostaAguardada.ASSUNTO)
public class ValorLogicoNotificacaoRespostaAguardadaAssunto
        extends
        ValorLogicoNotificacaoSBAssunto {

    public ValorLogicoNotificacaoRespostaAguardadaAssunto(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {

        if (!getNotificacaoRespostaAguardada().getStatus().equals(FabStatusNotificacao.REGISTRADA.getRegistro())) {

            return getNotificacaoRespostaAguardada().getConteudoHtml();

        }

        StringBuilder valor = new StringBuilder();
        valor.append(getNotificacaoRespostaAguardada().getNotificacaoOrigem().getUsuario().getNome())
                .append(" respondeu sobre ")
                .append(getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getNome());
        getNotificacaoRespostaAguardada().setAssunto(valor.toString());
        return getNotificacaoRespostaAguardada().getAssunto();
    }

    public NotificacaoRespostaAguardada getNotificacaoRespostaAguardada() {
        return (NotificacaoRespostaAguardada) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
