package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.etapas;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.projetos.notificacoes.model.FabDadosIniciaisNotificacoes;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio.EtapasNotificacaoSistemaBloqueio;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.FluxoNotificaoSistemaBloqueio;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class B_Quando_o_sistema_registra_uma_nova_notificacao_de_bloqueio_p_o_usuario_logado {

    @Quando(EtapasNotificacaoSistemaBloqueio.QUANDO_O_SISTEMA_REGISTRA_UMA_NOVA_NOTIFICACAO_DE_BLOQUEIO_P_O_USUARIO_LOGADO)
    public void implementacaoEtapa() {

        ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto();

        try {
            FluxoNotificaoSistemaBloqueio.notificacao = FluxoNotificaoSistemaMenu.GESTAO_NOTIFICACAO
                    .gerarNotificacao((TipoNotificacao) FabDadosIniciaisNotificacoes.TIPO_NOTIFICACAO_BLOQUEIO.getRegistro(), FluxoNotificaoSistemaBloqueio.USUARIO1);

        } catch (ErroGerandoNotificacao ex) {
            Assert.fail("Falhou iniciando uma notificação");
        }

    }
}
