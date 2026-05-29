/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoPadraoDev;
import br.org.carameloCode.projetos.notificacoes.api.FabAcaoNotificacaoWebView;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.CentralDadosJPAPadrao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfiguradorCoreDeProjetoJarPersistenciaAbstrato;
import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;

/**
 *
 * @author desenvolvedor
 */
public class ConfigCoreApiNotificacaoSBTestes extends ConfiguradorCoreDeProjetoJarPersistenciaAbstrato {//extends ConfiguradorCoreDeProjetoJarAbstrato {

    @Override
    public void defineClassesBasicas(ItfConfiguracaoCoreCustomizavel pConfig) {
        super.defineClassesBasicas(pConfig); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        pConfig.setCentralComunicacao(ServicoNotificacaoPadraoDev.class);
        pConfig.setCentralDados(CentralDadosJPAPadrao.class);
        pConfig.setClasseConfigPermissao(ConfigPermissaoTesteNotificacao.class);

    }

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        pConfig.setFabricaDeAcoes(new Class[]{FabAcaoNotificacaoPadraoSB.class, FabAcaoNotificacaoWebView.class});
    }

}
