package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

public class D_Entao_a_notificacao_deve_aparecer_no_servico_de_mensagens_do_destinatario {

    @Entao(EtapasNotificacaoEntreUsuarios.ENTAO_A_NOTIFICACAO_DEVE_APARECER_NO_SERVICO_DE_MENSAGENS_DO_DESTINATARIO)
    public void implementacaoEtapa() {

        Assert.assertFalse("Mensagem não encontrada", CarameloCode.getServicoComunicacao().getMsgColaboradorAguarandoMinhaResposta().isEmpty());

    }
}
