/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Notificação ", plural = "Notifcações ", icone = "fa fa-paper-plane-o", generoFeminino = false)
public class NotificacaoRespostaAguardada extends NotificacaoSB {

    @ManyToOne(targetEntity = NotificacaoUsrParaUsr.class)
    private NotificacaoSB notificacaoOrigem;

    public NotificacaoSB getNotificacaoOrigem() {
        return notificacaoOrigem;
    }

    public void setNotificacaoOrigem(NotificacaoSB notificacaoOrigem) {
        this.notificacaoOrigem = notificacaoOrigem;
    }

}
