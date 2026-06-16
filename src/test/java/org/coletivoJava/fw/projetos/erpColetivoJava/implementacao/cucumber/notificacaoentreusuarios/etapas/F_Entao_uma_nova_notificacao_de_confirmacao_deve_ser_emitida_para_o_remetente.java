package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Entao;
import java.lang.UnsupportedOperationException;

public class F_Entao_uma_nova_notificacao_de_confirmacao_deve_ser_emitida_para_o_remetente {

    @Entao(EtapasNotificacaoEntreUsuarios.ENTAO_UMA_NOVA_NOTIFICACAO_DE_CONFIRMACAO_DEVE_SER_EMITIDA_PARA_O_REMETENTE)
    public void implementacaoEtapa() {
        System.out.println("sem possibilidade de validar se a confirmação foi emitida");
    }
}
