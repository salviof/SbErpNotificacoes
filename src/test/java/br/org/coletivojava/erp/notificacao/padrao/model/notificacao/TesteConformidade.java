/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivoJava.testes.erp.ConfigCoreApiNotificacaoSBTestes;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaTestesNotificacao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigCoreJunitPadraoDesenvolvedorComPersistencia;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.Test;
import testesFW.ConfigCoreJunitPadraoDevAcaoPermissao;
import testesFW.TesteJunitSBPersistencia;

/**
 *
 * @author salvio
 */
public class TesteConformidade extends TesteJunitSBPersistencia {

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiNotificacaoSBTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaTestesNotificacao(), true, true);

    }

    @Test
    public void teste() {
        gerarCodigoModelProjeto();

    }
}
