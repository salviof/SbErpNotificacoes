/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.controller.FabAcaoNotificacaoPadraoSB;
import com.super_bits.modulos.SBAcessosModel.model.GrupoUsuarioSB;
import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabGrupoTestesNotifcacao implements ItfFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = GrupoUsuarioSB.class, id = 1l, nomeObjeto = "Grupo testes notificação")
    GRUPO_TESTE_NOTIFICACAO;

    @Override
    public GrupoUsuarioSB getRegistro() {
        GrupoUsuarioSB grupo = (GrupoUsuarioSB) ItfFabricaComPersistencia.super.getRegistro();
        grupo.setPaginaInicial(FabAcaoNotificacaoPadraoSB.NOTIFICACAO_MB_GESTAO);
        return grupo;
    }

}
