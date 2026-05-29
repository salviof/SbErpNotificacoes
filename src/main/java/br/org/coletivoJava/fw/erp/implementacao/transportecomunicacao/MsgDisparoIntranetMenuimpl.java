package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.modulos.erp.ItfServicoLinkDeEntidadesERP;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetMenuPadrao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetMenu;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroRegistrandoDialogo;
import java.util.logging.Level;
import java.util.logging.Logger;

@MsgDisparoIntranetMenu
public class MsgDisparoIntranetMenuimpl
        extends
        RepositorioLinkEntidadesGenerico
        implements
        com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao {

    @Override
    public void dispararRespostaComunicacao(ItfDialogo itfDialogo) {
    }

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
            com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo itfDialogo) {

        try {
            return CarameloCode.getServicoComunicacao().registrarDialogo(itfDialogo.getCodigoSelo(), itfDialogo).getCodigoSelo();
        } catch (ErroRegistrandoDialogo ex) {
            Logger.getLogger(MsgDisparoIntranetMenuimpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
