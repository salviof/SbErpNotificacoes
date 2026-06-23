package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Entao;
import org.junit.Assert;

public class H_Entao_o_remetente_visualiza_a_confirmacao_de_leitura_do_destinatario {

    @Entao(EtapasNotificacaoEntreUsuarios.ENTAO_O_REMETENTE_VISUALIZA_A_CONFIRMACAO_DE_LEITURA_DO_DESTINATARIO)
    public void implementacaoEtapa() {

        Assert.assertFalse("Nogificação não encontrada", CarameloCode.getServicoComunicacao().getNotificacoesAtivasMenu().isEmpty());
        ComoDialogo notificacaoREsposta = CarameloCode.getServicoComunicacao().getNotificacoesAtivasMenu().get(0);
        System.out.println(notificacaoREsposta.getAssunto());
        System.out.println(notificacaoREsposta.getMensagem());

    }
}
