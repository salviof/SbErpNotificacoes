package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import br.org.carameloCode.projetos.notificacoes.config.FabConfigModuloNotificacoLab;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Dado;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.FluxoNotificaoEntreUsuarios;
import org.junit.Assert;

public class A_Dado_que_o_usuario_remetente_esta_logado_no_sistema {

    @Dado(EtapasNotificacaoEntreUsuarios.DADO_QUE_O_USUARIO_REMETENTE_ESTA_LOGADO_NO_SISTEMA)
    public void implementacaoEtapa() {
        System.out.println(FabConfigModuloNotificacoLab.EMAIL_USUARIO1.getCaminhoArquivoVariaveisAmbiente());
        String email = FabConfigModuloNotificacoLab.EMAIL_USUARIO1.getValorParametroSistema();
        String email2 = FabConfigModuloNotificacoLab.EMAIL_USUARIO2.getValorParametroSistema();

        FluxoNotificaoEntreUsuarios.USUARIOREMETENTE = (UsuarioSB) CarameloCode.getServicoPermissao().getUsuarioByEmail(email);
        FluxoNotificaoEntreUsuarios.USUARIO_DESTINATARIO = (UsuarioSB) CarameloCode.getServicoPermissao().getUsuarioByEmail(email2);
        Assert.assertNotNull("Usuário destnatario não encontrado", FluxoNotificaoEntreUsuarios.USUARIOREMETENTE);
        Assert.assertNotNull("Usuário remetente não encontrado", FluxoNotificaoEntreUsuarios.USUARIO_DESTINATARIO);
        CarameloCode.getServicoSessao().getSessaoAtual().setUsuario(FluxoNotificaoEntreUsuarios.USUARIOREMETENTE);
        Assert.assertTrue("Falha autenticando", SBCore.getServicoSessao().getSessaoAtual().isIdentificado());
    }
}
