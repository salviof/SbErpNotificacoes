package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Dado;
import java.lang.UnsupportedOperationException;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class A_Dado_que_um_usuario_esta_logado_no_sistema {

    @Dado(EtapasNotificacaoSistemaMenu.DADO_QUE_UM_USUARIO_ESTA_LOGADO_NO_SISTEMA)
    public void implementacaoEtapa() {
        SBCore.getServicoSessao().logarEmailESenha(FluxoNotificaoSistemaMenu.EMAIL_USUARIO_NOTIFICACAO, FluxoNotificaoSistemaMenu.SENHA_USUARIO_NOTIFICACAO);
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
    }
}
