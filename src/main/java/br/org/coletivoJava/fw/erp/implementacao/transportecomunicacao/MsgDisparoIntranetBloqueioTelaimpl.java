package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetBloqueioTela;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

@MsgDisparoIntranetBloqueioTela
public class MsgDisparoIntranetBloqueioTelaimpl
        extends
        RepositorioLinkEntidadesGenerico
        implements
        ItfDisparoComunicacao {

    @Override
    public boolean validarDadosDisparo(ItfDialogo pDialogo) {
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

//                CarameloCode.getServicoComunicacao().notificarViaBloqueioTEla(pDialogo);
                if (recibo == null) {
                    return null;
                }
            }
            return recibo;
        } catch (Throwable t) {
            SBCore.RelatarErro(FabErro.SOLICITAR_REPARO, "Falha notificando via menu", t);
        }
        return null;
    }

}
