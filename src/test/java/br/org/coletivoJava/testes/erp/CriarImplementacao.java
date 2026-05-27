/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import org.apache.logging.log4j.LogManager;
import org.coletivojava.fw.api.objetoNativo.log.LogPadraoSB;
import org.junit.Test;
import testes.geradorCodigo.erp.GeradorERPImplementacaoContexto;
import testes.geradorCodigo.erp.dto.GeradorDTOInterface;
import testes.geradorCodigo.erp.dto.GeradorDTOPojo;
import testes.geradorCodigo.erp.dto.GeradorDTOProcessador;
import testesFW.ConfigCoreJunitPadraoDevAcaoPermissao;

/**
 *
 * @author salvio
 */
public class CriarImplementacao {

    private void implementacaoParao() {
        new GeradorERPImplementacaoContexto(ERPNotificacoes.NOTIFICACAO_PADRAO).salvarEmDiretorioPadraCASO_NAO_EXISTA();

        for (Class entidade : ERPNotificacoes.NOTIFICACAO_PADRAO.getInterfacesDeEntidade()) {
            GeradorDTOInterface geradorInterface = new GeradorDTOInterface(ERPNotificacoes.NOTIFICACAO_PADRAO, entidade);
            geradorInterface.salvarEmDiretorioPadraoSubstituindoAnterior();
            GeradorDTOPojo geradorPojo = new GeradorDTOPojo(ERPNotificacoes.NOTIFICACAO_PADRAO, entidade);
            geradorPojo.salvarEmDiretorioPadraCASO_NAO_EXISTA();
            GeradorDTOProcessador geradorProcessador = new GeradorDTOProcessador(ERPNotificacoes.NOTIFICACAO_PADRAO, entidade);
            geradorProcessador.salvarEmDiretorioPadraCASO_NAO_EXISTA();

        }
    }

    private void implementacaoTransporteMenu() {
        new GeradorERPImplementacaoContexto(ERPTipoCanalComunicacao.INTRANET_MENU).salvarEmDiretorioPadraCASO_NAO_EXISTA();

    }

    private void implementacaoTransporteModal() {
        //new GeradorERPImplementacaoContexto(ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA).salvarEmDiretorioPadraCASO_NAO_EXISTA();
    }

    @Test
    public void inicio() {
        try {
            SBCore.configurar(new ConfigCoreApiNotificacaoSBTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
            new GeradorERPImplementacaoContexto(ERPNotificacoes.NOTIFICACAO_PADRAO).salvarEmDiretorioPadraCASO_NAO_EXISTA();

            implementacaoParao();
            implementacaoTransporteMenu();
        } catch (Throwable t) {
            LogManager.getLogger(LogPadraoSB.class).error("Erro Criando anotações", t);
        }
    }

}
