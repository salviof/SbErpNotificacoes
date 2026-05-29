package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaosistemamenu.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemamenu.EtapasNotificacaoSistemaMenu;
import cucumber.api.java.pt.Quando;
import java.util.List;

public class E_Quando_o_usuario_marca_a_notificacao_como_lida {

    @Quando(EtapasNotificacaoSistemaMenu.QUANDO_O_USUARIO_MARCA_A_NOTIFICACAO_COMO_LIDA)
    public void implementacaoEtapa() {
        List<ItfDialogo> dialogos = CarameloCode.getServicoComunicacao().getArmazenamento().getComunicacoesAguardandoRespostaDoDestinatario(CarameloCode.getUsuarioLogado());
        CarameloCode.getServicoComunicacao().responderComunicacao(dialogos.get(0).getCodigoSelo(), dialogos.get(0).getRepostasPossiveis().get(0));
    }
}
