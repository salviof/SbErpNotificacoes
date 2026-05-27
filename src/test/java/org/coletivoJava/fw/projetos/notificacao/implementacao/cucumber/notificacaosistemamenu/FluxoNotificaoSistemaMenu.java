package org.coletivoJava.fw.projetos.notificacao.implementacao.cucumber.notificacaosistemamenu;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.coletivoJava.testes.erp.ConfigCoreApiNotificacaoSBTestes;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaTestesNotificacao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import cucumber.api.CucumberOptions;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.junit.runner.RunWith;
import testesFW.cucumber.CucumberSBTestes;
import testesFW.cucumber.TesteIntegracaoFuncionalidadeCucumber;

/**
 *
 * @author sfurbino
 */
@RunWith(CucumberSBTestes.class)
@CucumberOptions(features = "classpath:caracteristicas/notificacaoSistemaMenu", tags = "@NotificacaoSistemaMenu",
        glue = "org.coletivoJava.fw.projetos.notificacao.implementacao.cucumber.notificacaosistemamenu.etapas",
        monochrome = false, dryRun = false)
public class FluxoNotificaoSistemaMenu extends TesteIntegracaoFuncionalidadeCucumber {

    public static final String EMAIL_USUARIO_NOTIFICACAO = "atendimento@casanovadigital.com.br";
    public static final String SENHA_USUARIO_NOTIFICACAO = "123";
    public static NotificacaoSB notificacao;

    @Override
    protected void configAmbienteDesevolvimento() {

        ClassLoader classLoader = FluxoNotificaoSistemaMenu.class.getClassLoader();
        Enumeration<URL> recursos;
        try {
            List<String> lista = new ArrayList<>();
            String caminho = "caracteristicas/NotificacaoSistemaMenu";   // ← caminho relativo

            System.out.println("🔍 Tentando listar: " + caminho);

            Enumeration<URL> urls = FluxoNotificaoSistemaMenu.class.getClassLoader()
                    .getResources(caminho);

            int contadorUrls = 0;

            while (urls.hasMoreElements()) {
                URL url = urls.nextElement();
                contadorUrls++;
                System.out.println("🔗 URL " + contadorUrls + ": " + url);

                if (url.getProtocol().equals("file")) {

                    File pasta = new File(url.toURI());
                    System.out.println("   📁 Pasta encontrada: " + pasta.getAbsolutePath());

                    File[] arquivos = pasta.listFiles();
                    if (arquivos != null) {
                        for (File arq : arquivos) {
                            if (arq.isFile()) {
                                lista.add(arq.getName());
                                System.out.println("   ✅ Arquivo: " + arq.getName());
                            }
                        }
                    } else {
                        System.out.println("   ⚠️  Nenhum arquivo na pasta.");
                    }

                }
            }

            if (contadorUrls == 0) {
                System.out.println("❌ Nenhuma URL encontrada para o caminho: " + caminho);
                System.out.println("   Dica: Verifique se o caminho está correto a partir de 'src/test/ressources/'");
            }
        } catch (IOException | URISyntaxException ex) {
            Logger.getLogger(FluxoNotificaoSistemaMenu.class.getName()).log(Level.SEVERE, null, ex);
        }

        SBCore.configurar(new ConfigCoreApiNotificacaoSBTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaTestesNotificacao(), true, true);

    }

}
