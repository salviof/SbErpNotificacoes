/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivoJava.testes.erp.ConfigPersistenciaTestesNotificacao;
import br.org.coletivoJava.testes.erp.FabTipoNotificacaoTeste;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTransporteComunicacao;
import br.org.coletivojava.erp.notificacao.api.ERPNotificacoes;
import br.org.coletivojava.erp.notificacao.api.ItfERPNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.controller.ModuloNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigPersistenciaPadrao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import testesFW.ConfigCoreJunitPadraoDesenvolvedor;
import testesFW.TesteJunitSBPersistencia;

/**
 *
 * @author salvio
 */
public class NotificacaoTest extends TesteJunitSBPersistencia {

    public NotificacaoTest() {
    }

    @Test
    public void testSomeMethod() {
        // TODO review the generated test code and remove the default call to fail.

        ItfERPNotificacao notificacaoSrv = ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto();

        NotificacaoSB notificacao = notificacaoSrv.getNotificacao(FabTipoNotificacaoTeste.NOTIFICACAO_TESTE.getRegistro(), SBCore.getUsuarioLogado(), null);
        ModuloNotificacao.notificar(notificacao);
        //      notificacao.getReciboEntrega(ERPTransporteComunicacao.INTRANET_MENU, Long.MIN_VALUE);

    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreJunitPadraoDesenvolvedor(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaTestesNotificacao(), true, true);
    }

}
