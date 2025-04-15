/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
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
        return (TipoNotificacao) ItfFabricaComPersistencia.super.getRegistro(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
}
