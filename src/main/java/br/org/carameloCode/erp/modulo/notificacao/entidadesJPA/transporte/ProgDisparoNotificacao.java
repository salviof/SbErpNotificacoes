/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Programação de disparo", plural = "Disparos")
public class ProgDisparoNotificacao extends LogDisparoNotificacao {

    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataHoraProgramada;

    public Date getDataHoraProgramada() {
        return dataHoraProgramada;
    }

    public void setDataHoraProgramada(Date dataHoraProgramada) {
        this.dataHoraProgramada = dataHoraProgramada;
    }

}
