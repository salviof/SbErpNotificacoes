/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.api.ERPNotificacoes;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigCoreJunitPadraoDesenvolvedorComPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.apache.logging.log4j.LogManager;
import org.coletivojava.fw.api.objetoNativo.log.LogPadraoSB;

import org.junit.Test;
import testes.geradorCodigo.erp.GeradorAPIERP;
import testesFW.TesteJunit;
import testesFW.TesteJunitSBPersistencia;

/**
 *
 * @author desenvolvedor
 */
public class CriarAnoacoes extends TesteJunitSBPersistencia {

    @Test
    public void criarAnotacoes() {

        try {

            for (ERPNotificacoes trassp : ERPNotificacoes.values()) {
                GeradorAPIERP gerador = new GeradorAPIERP(trassp);
                gerador.salvarEmDiretorioPadraoSubstituindoAnterior();
            }
        } catch (Throwable t) {
            LogManager.getLogger(LogPadraoSB.class).error("Erro Criando anotações", t);
        }
    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreJunitPadraoDesenvolvedorComPersistencia(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }

}
