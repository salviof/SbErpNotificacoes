package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import br.org.carameloCode.projetos.notificacoes.config.FabConfigModuloNotificacoLab;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.FluxoNotificaoEntreUsuarios;
import org.junit.Assert;

public class C_Dado_que_o_usuario_destinatario_acessa_o_sistema {

    @Dado(EtapasNotificacaoEntreUsuarios.DADO_QUE_O_USUARIO_DESTINATARIO_ACESSA_O_SISTEMA)
    public void implementacaoEtapa() {

        CarameloCode.getServicoSessao().getSessaoAtual().setUsuario(FluxoNotificaoEntreUsuarios.USUARIO_DESTINATARIO);
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().getUsuario().getEmail().equals(FabConfigModuloNotificacoLab.EMAIL_USUARIO2.getValorParametroSistema()));
    }
}
