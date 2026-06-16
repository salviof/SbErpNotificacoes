package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaousrparausr;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr.ValorLogicoNotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr.ValoresLogicosNotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb.ValorLogicoNotificacaoSBAssunto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoUsrParaUsr(calculo = ValoresLogicosNotificacaoUsrParaUsr.ASSUNTO)
public class ValorLogicoNotificacaoUsrParaUsrAssunto
        extends
        ValorLogicoNotificacaoSBAssunto {

    public ValorLogicoNotificacaoUsrParaUsrAssunto(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {
        return super.getValor(pEntidade); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public NotificacaoUsrParaUsr getNotificacaoUsrParaUsr() {
        return (NotificacaoUsrParaUsr) getCampoInst().getObjetoRaizDoAtributo();
    }
}
