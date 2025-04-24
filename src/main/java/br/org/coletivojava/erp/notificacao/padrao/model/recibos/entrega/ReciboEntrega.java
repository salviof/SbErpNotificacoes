/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.recibos.entrega;

import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Recibo de entrega", plural = "Recibos de entrega")
public class ReciboEntrega extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = LogDisparoNotificacao.class)
    private LogDisparoNotificacao disparo;

    @Column(length = 512)
    private String codigoEntrega;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoEntrega() {
        return codigoEntrega;
    }

    public void setCodigoEntrega(String codigoEntrega) {
        this.codigoEntrega = codigoEntrega;
    }

    public LogDisparoNotificacao getDisparo() {
        return disparo;
    }

    public void setDisparo(LogDisparoNotificacao disparo) {
        this.disparo = disparo;
    }

}
