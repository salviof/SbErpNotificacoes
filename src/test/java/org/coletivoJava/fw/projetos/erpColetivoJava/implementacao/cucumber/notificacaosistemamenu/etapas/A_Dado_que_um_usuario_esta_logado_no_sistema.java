package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import br.org.carameloCode.projetos.notificacoes.config.FabConfigModuloNotificacoLab;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class A_Dado_que_um_usuario_esta_logado_no_sistema {

    @Dado(EtapasNotificacaoSistemaMenu.DADO_QUE_UM_USUARIO_ESTA_LOGADO_NO_SISTEMA)
    public void implementacaoEtapa() {

        System.out.println(FabConfigModuloNotificacoLab.EMAIL_USUARIO1.getCaminhoArquivoVariaveisAmbiente());
        String email = FabConfigModuloNotificacoLab.EMAIL_USUARIO1.getValorParametroSistema();

        FluxoNotificaoSistemaMenu.USUARIO1 = (UsuarioSB) CarameloCode.getServicoPermissao().getUsuarioByEmail(email);
        FluxoNotificaoSistemaMenu.USUARIO2 = (UsuarioSB) CarameloCode.getServicoPermissao().getUsuarioByEmail(FabConfigModuloNotificacoLab.EMAIL_USUARIO2.getValorParametroSistema());
        CarameloCode.getServicoSessao().getSessaoAtual().setUsuario(FluxoNotificaoSistemaMenu.USUARIO1);
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
    }
}
