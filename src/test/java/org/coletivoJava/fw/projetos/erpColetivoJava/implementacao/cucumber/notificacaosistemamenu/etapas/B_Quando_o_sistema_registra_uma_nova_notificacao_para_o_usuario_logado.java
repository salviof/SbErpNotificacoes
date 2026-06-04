package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.projetos.notificacoes.model.FabDadosIniciaisNotificacoes;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class B_Quando_o_sistema_registra_uma_nova_notificacao_para_o_usuario_logado {

    @Quando(EtapasNotificacaoSistemaMenu.QUANDO_O_SISTEMA_REGISTRA_UMA_NOVA_NOTIFICACAO_PARA_O_USUARIO_LOGADO)
    public void implementacaoEtapa() {

        try {
            FluxoNotificaoSistemaMenu.notificacao = FluxoNotificaoSistemaMenu.GESTAO_NOTIFICACAO.gerarNotificacao((TipoNotificacao) FabDadosIniciaisNotificacoes.TIPO_NOTIFICACAO_MENU.getRegistro(), FluxoNotificaoSistemaMenu.USUARIO1);
        } catch (ErroGerandoNotificacao ex) {
            Assert.fail(ex.getMessage());
        }

    }
}
