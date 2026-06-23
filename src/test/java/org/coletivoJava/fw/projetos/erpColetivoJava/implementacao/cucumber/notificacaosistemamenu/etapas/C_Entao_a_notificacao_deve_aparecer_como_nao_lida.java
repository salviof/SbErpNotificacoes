package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.junit.Assert;

public class C_Entao_a_notificacao_deve_aparecer_como_nao_lida {

    @Entao(EtapasNotificacaoSistemaMenu.ENTAO_A_NOTIFICACAO_DEVE_APARECER_COMO_NAO_LIDA)
    public void implementacaoEtapa() {

        List<ComoDialogo> dialogos = CarameloCode.getServicoComunicacao().getNotificacoesAtivasMenu();
        Assert.assertFalse("Sem dialogos registrados", dialogos.isEmpty());
    }
}
