/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.fabrica.ComoFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabGruposPadrao;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public enum FabUsuariosTestesNotificacao implements ComoFabricaComPersistencia {
    @InfoObjetoDaFabrica(classeObjeto = UsuarioSB.class, id = 1l, nomeObjeto = "Sálvio")
    SALVIO;

    @Override
    public UsuarioSB getRegistro() {
        UsuarioSB usuario = (UsuarioSB) ComoFabricaComPersistencia.super.getRegistro();

        usuario.setEmail("salvio@casanovadigital.com.br");
        usuario.setTelefone("31984178550");
        usuario.setGrupo(FabGrupoTestesNotifcacao.GRUPO_TESTE_NOTIFICACAO.getRegistro());
        return usuario;
    }

    @Override
    public UsuarioSB getRegistro(EntityManager pEm) {
        return (UsuarioSB) ComoFabricaComPersistencia.super.getRegistro(pEm); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
