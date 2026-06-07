package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetMenu;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

@MsgDisparoIntranetMenu
public class MsgDisparoIntranetMenuimpl
        extends
        RepositorioLinkEntidadesGenerico
        implements
        com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao {

    @Override
    public boolean validarDadosDisparo(
            com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo pDialogo) {
        if (pDialogo.getAssunto() == null) {
            return false;
        }

        return true;
    }

    @Override
    public String dispararInicioComunicacao(
            com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo pDialogo) {
        try {
            String recibo = pDialogo.getCodigoSelo();
            if (CarameloCode.getServicoComunicacao().getArmazenamento().registrarDialogoAtivo(pDialogo)) {

                if (!CarameloCode.getServicoComunicacao().notificarViaMenu(pDialogo)) {
                    // Usuário não estava online, não houve confirmaçao de notificação mas foi registrado para
                    // aparecer no menu
                    return recibo;
                }
                if (recibo == null) {
                    return null;
                }
                return recibo;
            } else {
                // falha registrando dialogo no menu
                return null;
            }

        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha notificando via menu", t);
        }
        return null;
    }
}
