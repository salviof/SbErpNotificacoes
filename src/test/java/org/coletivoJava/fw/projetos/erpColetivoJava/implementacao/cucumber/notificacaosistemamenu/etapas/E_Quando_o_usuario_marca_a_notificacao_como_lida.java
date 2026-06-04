package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;

public class E_Quando_o_usuario_marca_a_notificacao_como_lida {

    @Quando(EtapasNotificacaoSistemaMenu.QUANDO_O_USUARIO_MARCA_A_NOTIFICACAO_COMO_LIDA)
    public void implementacaoEtapa() {

        FluxoNotificaoSistemaMenu.atualizarEntidadesDeclaradas();
        NotificacaoSB ntf = FluxoNotificaoSistemaMenu.notificacao;
        LogDisparoNotificacao disparo = ntf.getDisparos().get(0);
        FluxoNotificaoSistemaMenu.GESTAO_NOTIFICACAO.registrarReciboLeitura(disparo.getCodigoRegistroEnvio(), UtilCRCStringGerador.getStringRandomicaUUID());

    }
}
