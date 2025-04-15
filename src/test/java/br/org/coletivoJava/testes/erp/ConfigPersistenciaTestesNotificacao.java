/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import com.google.common.collect.Lists;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.ConfigPersistenciaPadrao;
import com.super_bits.modulosSB.SBCore.modulos.fabrica.ItfFabrica;

/**
 *
 * @author salvio
 */
public class ConfigPersistenciaTestesNotificacao extends ConfigPersistenciaPadrao {

    @Override
    public String bancoPrincipal() {
        return "SbErpNotificacoesModel";
    }

    @Override
    public Class<? extends ItfFabrica>[] fabricasRegistrosIniciais() {
        return new Class[]{FabTipoNotificacaoTeste.class};
    }

}
