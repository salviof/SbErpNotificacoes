/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Pedido PErmissao", plural = "Pedidos de permissão")
public class NotificacaoPermissao extends NotificacaoUsrParaUsr {

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoPermitida;

    public AcaoDoSistema getAcaoPermitida() {
        return acaoPermitida;
    }

    public void setAcaoPermitida(AcaoDoSistema acaoPermitida) {
        this.acaoPermitida = acaoPermitida;
    }

}
