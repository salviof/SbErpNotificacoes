/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.model.PessoaTeste;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabTipoNotificacaoTeste implements ItfFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = TipoNotificacao.class, nomeObjeto = "Notificação teste")
    NOTIFICACAO_TESTE,;

    @Override
    public TipoNotificacao getRegistro() {
        TipoNotificacao tipo = (TipoNotificacao) ItfFabricaComPersistencia.super.getRegistro();
        tipo.setTipoEntidade(PessoaTeste.class.getSimpleName());
        tipo.setConteudoHTML("<h1> Olá [nome] </h1> ");
        return tipo;
    }
}
