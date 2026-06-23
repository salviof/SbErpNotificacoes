package org.coletivoJava.fw.projetos.erpColetivoJava.implementacao.cucumber.notificacaoentreusuarios.etapas;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComoDialogoEntrePessoas;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfRespostaComunicacao;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios.EtapasNotificacaoEntreUsuarios;
import cucumber.api.java.pt.Quando;
import java.util.List;

public class E_Quando_o_destinatario_marca_a_notificacao_como_lida {

    @Quando(EtapasNotificacaoEntreUsuarios.QUANDO_O_DESTINATARIO_MARCA_A_NOTIFICACAO_COMO_LIDA)
    public void implementacaoEtapa() {

        List<ComoDialogoEntrePessoas> mensgens = CarameloCode.getServicoComunicacao().getMsgColaboradorAguarandoMinhaResposta();
        ComoDialogoEntrePessoas dialogo = mensgens.get(0);
        ItfRespostaComunicacao respostaPositiva = dialogo.getRepostasPossiveis().stream().filter(rp -> rp.getTipoResposta().isRespostasPosiva()).findFirst().get();
        CarameloCode.getServicoComunicacao().responderComunicacao(dialogo.getCodigoSelo(),
                respostaPositiva, ERPTipoCanalComunicacao.INTRANET_MENU);
    }
}
