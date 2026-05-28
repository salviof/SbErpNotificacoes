/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.carameloCode.erp.modulo.notificacao.api.FabAcaoNotificacaoPadraoSB;
import br.org.carameloCode.erp.modulo.notificacao.controller.ServicoNotificacaoPadraoDev;
import br.org.carameloCode.projetos.notificacoes.api.FabAcaoNotificacaoWebView;
import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;
import testesFW.ConfigCoreJunitPadraoDevAcaoPermissao;

/**
 *
 * @author desenvolvedor
 */
public class ConfigCoreApiNotificacaoSBTestes extends ConfigCoreJunitPadraoDevAcaoPermissao {//extends ConfiguradorCoreDeProjetoJarAbstrato {

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        super.defineFabricasDeACao(pConfig);

        pConfig.setCentralComunicacao(ServicoNotificacaoPadraoDev.class);

        pConfig.setClasseConfigPermissao(ConfigPermissaoTesteNotificacao.class);
        pConfig.setFabricaDeAcoes(new Class[]{FabAcaoNotificacaoPadraoSB.class, FabAcaoNotificacaoWebView.class});

    }

}
