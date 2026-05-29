package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import br.org.carameloCode.erp.modulo.notificacao.controller.ModuloNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.projetos.notificacoes.model.FabDadosIniciaisNotificacoes;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;

public class B_Quando_o_sistema_registra_uma_nova_notificacao_para_o_usuario_logado {

    @Quando(EtapasNotificacaoSistemaMenu.QUANDO_O_SISTEMA_REGISTRA_UMA_NOVA_NOTIFICACAO_PARA_O_USUARIO_LOGADO)
    public void implementacaoEtapa() {
        NotificacaoSB notificacao = new NotificacaoSB();
        notificacao.setTipoNotificacao((TipoNotificacao) FabDadosIniciaisNotificacoes.TIPO_NOTIFICACAO_MENU.getRegistro());
        notificacao.setUsuario(FluxoNotificaoSistemaMenu.USUARIO1);

        ItfRespostaAcaoDoSistema resposta = ModuloNotificacao.notificacaoRegistrar(notificacao);
        FluxoNotificaoSistemaMenu.notificacao = (NotificacaoSB) resposta.getRetorno();
    }
}
