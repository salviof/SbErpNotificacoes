package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio.EtapasNotificacaoSistemaBloqueio;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.junit.Assert;

public class C_Entao_a_notificacao_deve_aparecer_na_lista_de_mensagem_de_bloqueio {

    @Entao(EtapasNotificacaoSistemaBloqueio.ENTAO_A_NOTIFICACAO_DEVE_APARECER_NA_LISTA_DE_MENSAGEM_DE_BLOQUEIO)
    public void implementacaoEtapa() {
        List<ComoDialogo> dialogosBloqueio = CarameloCode.getServicoComunicacao().getNotificacoesAtivasBloqueioTela();
        Assert.assertFalse("O dialogo de bloqueio não foi listado", dialogosBloqueio.isEmpty());
    }
}
