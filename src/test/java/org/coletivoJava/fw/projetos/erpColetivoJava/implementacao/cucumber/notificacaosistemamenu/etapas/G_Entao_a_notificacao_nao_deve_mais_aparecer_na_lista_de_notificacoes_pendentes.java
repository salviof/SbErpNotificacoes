package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.junit.Assert;

public class G_Entao_a_notificacao_nao_deve_mais_aparecer_na_lista_de_notificacoes_pendentes {

    @Entao(EtapasNotificacaoSistemaMenu.E_A_NOTIFICACAO_NAO_DEVE_MAIS_APARECER_NA_LISTA_DE_NOTIFICACOES_PENDENTES)
    public void implementacaoEtapa() {
        List<ComoDialogo> dialogos = CarameloCode.getServicoComunicacao().getNotificacoesAtivasMenu();
        Assert.assertTrue("Sem dialogos registrados", dialogos.isEmpty());
    }
}
