/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.transporte;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.recibos.entrega.ReciboEntrega;
import br.org.coletivojava.erp.notificacao.padrao.model.recibos.leitura.ReciboLeitura;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Disparo de Notificação", plural = "Disparos")
public class LogDisparoNotificacao extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = NotificacaoSB.class, optional = false)
    private NotificacaoSB notificacao;

    @Enumerated(EnumType.STRING)
    private ERPTipoCanalComunicacao tipoTransporte;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean foiEnviado;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean foiLido;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHoraDisparo = new Date();

    private String codigoRegistroEnvio;

    @ManyToOne(targetEntity = ReciboEntrega.class, cascade = CascadeType.ALL, optional = false)
    private ReciboEntrega reciboEntrega;

    @OneToOne(targetEntity = ReciboLeitura.class, mappedBy = "disparo", cascade = CascadeType.ALL, optional = true)
    private ReciboLeitura reciboLeitura;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public NotificacaoSB getNotificacao() {
        return notificacao;
    }

    public void setNotificacao(NotificacaoSB notificacao) {
        this.notificacao = notificacao;
    }

    public ERPTipoCanalComunicacao getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(ERPTipoCanalComunicacao tipoTransporte) {
        this.tipoTransporte = tipoTransporte;
    }

    public boolean isFoiEnviado() {
        return foiEnviado;
    }

    public void setFoiEnviado(boolean foiEnviado) {
        this.foiEnviado = foiEnviado;
    }

    public boolean isFoiLido() {
        return foiLido;
    }

    public void setFoiLido(boolean foiLido) {
        this.foiLido = foiLido;
    }

    public ReciboEntrega getReciboEntrega() {
        return reciboEntrega;
    }

    public void setReciboEntrega(ReciboEntrega reciboEntrega) {
        this.reciboEntrega = reciboEntrega;
    }

    public ReciboLeitura getReciboLeitura() {
        return reciboLeitura;
    }

    public void setReciboLeitura(ReciboLeitura reciboLeitura) {
        this.reciboLeitura = reciboLeitura;
    }

    public Date getDataHoraDisparo() {
        return dataHoraDisparo;
    }

    public void setDataHoraDisparo(Date dataHoraDisparo) {
        this.dataHoraDisparo = dataHoraDisparo;
    }

    public String getCodigoRegistroEnvio() {
        return codigoRegistroEnvio;
    }

    public void setCodigoRegistroEnvio(String codigoRegistroEnvio) {
        this.codigoRegistroEnvio = codigoRegistroEnvio;
    }

}
