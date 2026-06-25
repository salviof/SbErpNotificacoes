package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.etapas;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.DialogoNotificacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroDetectandoTelaBloqueio;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio.EtapasNotificacaoSistemaBloqueio;
import cucumber.api.java.pt.Quando;
import org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemabloqueio.FluxoNotificaoSistemaBloqueio;
import org.coletivojava.fw.api.tratamentoErros.FabErro;
import org.junit.Assert;

public class D_Quando_o_usuario_marca_a_notificacao_como_lida {

    @Quando(EtapasNotificacaoSistemaBloqueio.QUANDO_O_USUARIO_MARCA_A_NOTIFICACAO_COMO_LIDA)
    public void implementacaoEtapa() {

        FluxoNotificaoSistemaBloqueio.atualizarEntidadesDeclaradas();
        DialogoNotificacao dialogo = FluxoNotificaoSistemaBloqueio.notificacao.getDialogo();
        boolean notificado;

        notificado = CarameloCode.getServicoComunicacao().notificarViaBloqueioTEla(dialogo);
        Assert.assertTrue(notificado);

    }
}
