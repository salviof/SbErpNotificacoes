package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Entao;
import java.lang.UnsupportedOperationException;
import java.util.List;
import org.junit.Assert;

public class C_Entao_a_notificacao_deve_aparecer_como_nao_lida {

    @Entao(EtapasNotificacaoSistemaMenu.ENTAO_A_NOTIFICACAO_DEVE_APARECER_COMO_NAO_LIDA)
    public void implementacaoEtapa() {
        List<ItfDialogo> dialogos = CarameloCode.getServicoComunicacao().getArmazenamento().getComunicacoesAguardandoRespostaDoDestinatario(CarameloCode.getUsuarioLogado());
        Assert.assertFalse("Sem dialogos registrados", dialogos.isEmpty());
    }
}
