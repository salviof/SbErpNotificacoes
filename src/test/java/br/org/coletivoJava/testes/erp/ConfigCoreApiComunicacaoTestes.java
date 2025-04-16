/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.controller.FabAcaoNotificacaoPadraoSB;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigCoreJunitPadraoDesenvolvedorComPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.ItfConfiguracaoCoreCustomizavel;

/**
 *
 * @author desenvolvedor
 */
public class ConfigCoreApiComunicacaoTestes extends ConfigCoreJunitPadraoDesenvolvedorComPersistencia {//extends ConfiguradorCoreDeProjetoJarAbstrato {

    @Override
    public void defineFabricasDeACao(ItfConfiguracaoCoreCustomizavel pConfig) {
        super.defineFabricasDeACao(pConfig);

        pConfig.setFabricaDeAcoes(new Class[]{FabAcaoNotificacaoPadraoSB.class});

    }

}
