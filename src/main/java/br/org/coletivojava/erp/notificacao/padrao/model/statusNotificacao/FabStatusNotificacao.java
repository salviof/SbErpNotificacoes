/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao;

import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;

/**
 *
 * @author salvio
 */
public enum FabStatusNotificacao implements ItfFabricaComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 1l, nomeObjeto = "Registrado")
    REGISTRADA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 2l, nomeObjeto = "Entregue")
    ENTREGUE,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 3l, nomeObjeto = "Lida")
    LIDA

}
