package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.projetos.notificacoes.model.FabDadosIniciaisNotificacoes;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.FluxoNotificaoEntreUsuarios;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class B_Quando_o_remetente_registra_uma_nova_notificacao_para_o_destinatario {

    @Quando(EtapasNotificacaoEntreUsuarios.QUANDO_O_REMETENTE_REGISTRA_UMA_NOVA_NOTIFICACAO_PARA_O_DESTINATARIO)
    public void implementacaoEtapa() {

        try {
            FluxoNotificaoEntreUsuarios.renovarConexaoEntityManagerEscopoTeste();
            TipoNotificacaoUsrComUsr tipo = (TipoNotificacaoUsrComUsr) FabDadosIniciaisNotificacoes.TIPO_NOTIFICACAO_USR_TO_USR.getRegistro(FluxoNotificaoEntreUsuarios.getEM());
            FluxoNotificaoEntreUsuarios.notificacao = FluxoNotificaoSistemaMenu.GESTAO_NOTIFICACAO
                    .gerarNotificacaoEntreUsuarios(tipo,
                            FluxoNotificaoEntreUsuarios.USUARIOREMETENTE, FluxoNotificaoEntreUsuarios.USUARIO_DESTINATARIO);
        } catch (ErroGerandoNotificacao ex) {

            Assert.fail("Falha gerando Notificação");
        }

    }
}
