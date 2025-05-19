package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.notificacaosb;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.ValorLogicoNotificacaoSB;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValorLogicoNotificacaoSB(calculo = ValoresLogicosNotificacaoSB.ASSUNTO)
public class ValorLogicoNotificacaoSBAssunto extends ValorLogicoNotificacaoPalavrasChave {

    public ValorLogicoNotificacaoSBAssunto(ItfCampoInstanciado pCampo) {
        super(pCampo, ((NotificacaoSB) pCampo.getObjetoRaizDoAtributo()).getTipoNotificacao().getAssunto());
    }

    @Override
    public Object getValor(Object... pEntidade) {

        return super.getValor(pEntidade);
    }

    public NotificacaoSB getNotificacao() {
        return (NotificacaoSB) getCampoInst().getObjetoRaizDoAtributo();
    }
}
