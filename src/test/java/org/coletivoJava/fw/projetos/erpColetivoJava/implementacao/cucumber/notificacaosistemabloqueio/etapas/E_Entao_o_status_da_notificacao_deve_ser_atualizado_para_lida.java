package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.etapas;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio.EtapasNotificacaoSistemaBloqueio;
import cucumber.api.java.pt.Entao;
import java.lang.UnsupportedOperationException;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.FluxoNotificaoSistemaBloqueio;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class E_Entao_o_status_da_notificacao_deve_ser_atualizado_para_lida {

    @Entao(EtapasNotificacaoSistemaBloqueio.ENTAO_O_STATUS_DA_NOTIFICACAO_DEVE_SER_ATUALIZADO_PARA_LIDA)
    public void implementacaoEtapa() {
        FluxoNotificaoSistemaBloqueio.atualizarEntidadesDeclaradas();
        NotificacaoSB ntf = FluxoNotificaoSistemaBloqueio.notificacao;

        Assert.assertEquals("O Status não foi alterado", FabStatusNotificacao.LIDA.getRegistro(), ntf.getStatus());
    }
}
