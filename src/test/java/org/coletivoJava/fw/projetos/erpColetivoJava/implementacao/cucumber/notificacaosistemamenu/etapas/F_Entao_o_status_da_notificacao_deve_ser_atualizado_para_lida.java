package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Entao;
import java.util.List;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.FluxoNotificaoSistemaMenu;
import org.junit.Assert;

public class F_Entao_o_status_da_notificacao_deve_ser_atualizado_para_lida {

    @Entao(EtapasNotificacaoSistemaMenu.ENTAO_O_STATUS_DA_NOTIFICACAO_DEVE_SER_ATUALIZADO_PARA_LIDA)
    public void implementacaoEtapa() {
        FluxoNotificaoSistemaMenu.atualizarEntidadesDeclaradas();
        NotificacaoSB ntf = FluxoNotificaoSistemaMenu.notificacao;

        Assert.assertEquals("O Status não foi alterado", FabStatusNotificacao.LIDA.getRegistro(), ntf.getStatus());

    }
}
