/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivoJava.testes.erp.ConfigCoreApiComunicacaoTestes;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaTestesNotificacao;
import br.org.coletivoJava.testes.erp.FabTipoNotificacaoTeste;
import br.org.coletivoJava.testes.erp.FabUsuariosTestesNotificacao;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.api.ERPNotificacoes;
import br.org.coletivojava.erp.notificacao.api.ErroGerandoNotificacao;
import br.org.coletivojava.erp.notificacao.api.ItfERPNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.controller.ModuloNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.model.PessoaTeste;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import testesFW.ConfigCoreJunitPadraoDevAcaoPermissao;
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
        assertTrue("Para testes de notificação, utilize a implmentação de comunicação via email", ERPTipoCanalComunicacao.EMAIL.isTipoTransporteImplementado());
        ItfERPNotificacao notificacaoSrv = ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto();
        UsuarioSB usuarioTeste = FabUsuariosTestesNotificacao.SALVIO.getRegistro(getEM());
        PessoaTeste itemPessoaTeste = new PessoaTeste();
        itemPessoaTeste.setNome("Zé lélé");
        itemPessoaTeste.setDescricao("Apenas teste");
        itemPessoaTeste.setId(1l);
        NotificacaoSB notificacao;
        try {
            notificacao = notificacaoSrv.
                    getNotificacao(FabTipoNotificacaoTeste.NOTIFICACAO_TESTE.getRegistro(),
                            usuarioTeste, itemPessoaTeste);
            notificacao.getCPinst("conteudo").getValor();
            ModuloNotificacao.notificacaoRegistrar(notificacao);
        } catch (ErroGerandoNotificacao ex) {
            Logger.getLogger(NotificacaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        ModuloNotificacao.notificacaoEnviar();
        //      notificacao.getReciboEntrega(ERPTransporteComunicacao.INTRANET_MENU, Long.MIN_VALUE);

    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiComunicacaoTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaTestesNotificacao(), true, true);
        MapaObjetosProjetoAtual.adcionarObjeto(PessoaTeste.class);
    }

}
