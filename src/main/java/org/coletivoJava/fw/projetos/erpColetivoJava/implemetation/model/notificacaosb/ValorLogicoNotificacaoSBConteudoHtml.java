package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.notificacaosb;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.ValorLogicoNotificacaoSB;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoSB(calculo = ValoresLogicosNotificacaoSB.CONTEUDOHTML)
public class ValorLogicoNotificacaoSBConteudoHtml
        extends ValorLogicoNotificacaoPalavrasChave {

    public ValorLogicoNotificacaoSBConteudoHtml(ItfCampoInstanciado pCampo) {
        super(pCampo, ((NotificacaoSB) pCampo.getObjetoRaizDoAtributo()).getTipoNotificacao().getConteudoHTML());
    }

    @Override
    public Object getValor(Object... pEntidade) {
        String valor = (String) super.getValor(pEntidade);
        getNotificacao().setAssunto(valor);
        return getNotificacao().getAssunto();
    }

    public NotificacaoSB getNotificacao() {
        return (NotificacaoSB) getCampoInst().getObjetoRaizDoAtributo();
    }

}
