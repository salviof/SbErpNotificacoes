/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.transporte;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTransporteComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Transporte", plural = "Transportes")
public class TransporteNotificacao extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = NotificacaoSB.class)
    private NotificacaoSB notificacao;

    @Enumerated(EnumType.STRING)
    private ERPTransporteComunicacao tipoTransporte;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean foiEnviado;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean foiLido;

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

    public ERPTransporteComunicacao getTipoTransporte() {
        return tipoTransporte;
    }

    public void setTipoTransporte(ERPTransporteComunicacao tipoTransporte) {
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

}
