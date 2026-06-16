package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import br.org.carameloCode.projetos.notificacoes.config.FabConfigModuloNotificacoLab;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Dado;
import java.lang.UnsupportedOperationException;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.FluxoNotificaoEntreUsuarios;
import org.junit.Assert;

public class G_Dado_que_o_remetente_realiza_novo_acesso_ao_sistema {

    @Dado(EtapasNotificacaoEntreUsuarios.DADO_QUE_O_REMETENTE_REALIZA_NOVO_ACESSO_AO_SISTEMA)
    public void implementacaoEtapa() {
        CarameloCode.getServicoSessao().getSessaoAtual().setUsuario(FluxoNotificaoEntreUsuarios.USUARIOREMETENTE);
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().getUsuario().getEmail().equals(FabConfigModuloNotificacoLab.EMAIL_USUARIO1.getValorParametroSistema()));
    }
}
