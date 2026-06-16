package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.projetos.notificacoes.config.ConfigPersistenciaCarameloNotficacaoDemo;
import br.org.coletivoJava.testes.erp.ConfigCoreApiNotificacaoSBTestes;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.CucumberOptions;

import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/NotificacaoEntreUsuarios", tags = "@NotificacaoEntreUsuarios",
        glue = "org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas",
        monochrome = false, dryRun = false)
public class FluxoNotificaoEntreUsuarios extends TesteIntegracaoFuncionalidadeCucumber {

    public static NotificacaoSB notificacao;
    public static UsuarioSB USUARIOREMETENTE;
    public static UsuarioSB USUARIO_DESTINATARIO;

    @Override
    protected void configAmbienteDesevolvimento() {

        SBCore.configurar(new ConfigCoreApiNotificacaoSBTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(
                new ConfigPersistenciaCarameloNotficacaoDemo(), true, true);

    }

}
