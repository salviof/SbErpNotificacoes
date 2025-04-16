/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.recibos.leitura;

import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(tags = "Recibo Leitura", plural = "Recibos de Leitura")
@Entity
public class ReciboLeitura extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = LogDisparoNotificacao.class, optional = true)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private LogDisparoNotificacao disparo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @Column(length = 512)
    private String codigoLeitura;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataHoraLeitura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LogDisparoNotificacao getDisparo() {
        return disparo;
    }

    public void setDisparo(LogDisparoNotificacao disparo) {
        this.disparo = disparo;
    }

    public String getCodigoLeitura() {
        return codigoLeitura;
    }

    public void setCodigoLeitura(String codigoLeitura) {
        this.codigoLeitura = codigoLeitura;
    }

    public Date getDataHoraLeitura() {
        return dataHoraLeitura;
    }

    public void setDataHoraLeitura(Date dataHoraLeitura) {
        this.dataHoraLeitura = dataHoraLeitura;
    }

}
