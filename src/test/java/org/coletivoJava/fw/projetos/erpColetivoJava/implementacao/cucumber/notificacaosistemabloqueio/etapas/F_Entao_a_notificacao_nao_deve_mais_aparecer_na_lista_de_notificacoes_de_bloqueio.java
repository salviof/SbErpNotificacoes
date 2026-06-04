package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio.EtapasNotificacaoSistemaBloqueio;
import cucumber.api.java.pt.Entao;
import java.lang.UnsupportedOperationException;
import java.util.List;
import org.junit.Assert;

public class F_Entao_a_notificacao_nao_deve_mais_aparecer_na_lista_de_notificacoes_de_bloqueio {

    @Entao(EtapasNotificacaoSistemaBloqueio.E_A_NOTIFICACAO_NAO_DEVE_MAIS_APARECER_NA_LISTA_DE_NOTIFICACOES_DE_BLOQUEIO)
    public void implementacaoEtapa() {
        List<ItfDialogo> dialogos = CarameloCode.getServicoComunicacao().getNotificacoesAtivasMenu();
        Assert.assertTrue("Sem dialogos registrados", dialogos.isEmpty());
    }
}
