/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao;

import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeNormal;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Tipo de Notificação"}, plural = "Tipos de Notificação", icone = "fa fa-user")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
public class TipoNotificacao extends EntidadeNormal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String assunto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    private String conteudo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML_TEMPLATE)
    private String conteudoHTML;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoNotificacao;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoAutoExecucao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean exigirReciboDeEntrega;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean exigirReciboLeitura;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificacaoUnica = true;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notifificarViaMatrix;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaIntranet;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaTelaDeBLoqueio;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaMobile;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaWhatsapp;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaApiPersonalizada;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaSMS;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso
    private boolean notificarViaEmail = true;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    private int minutosRenotificacao;

    @InfoCampo(tipo = FabTipoAtributoObjeto.QUANTIDADE)
    private int diasLog;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEntidade() {
        return tipoEntidade;
    }

    public void setTipoEntidade(String tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }

    public AcaoDoSistema getAcaoNotificacao() {
        return acaoNotificacao;
    }

    public void setAcaoNotificacao(AcaoDoSistema acaoNotificacao) {
        this.acaoNotificacao = acaoNotificacao;
    }

    public boolean isNotificacaoUnica() {
        return notificacaoUnica;
    }

    public void setNotificacaoUnica(boolean notificacaoUnica) {
        this.notificacaoUnica = notificacaoUnica;
    }

    public boolean isNotifificarViaMatrix() {
        return notifificarViaMatrix;
    }

    public void setNotifificarViaMatrix(boolean notifificarViaMatrix) {
        this.notifificarViaMatrix = notifificarViaMatrix;
    }

    public boolean isNotificarViaIntranet() {
        return notificarViaIntranet;
    }

    public void setNotificarViaIntranet(boolean notificarViaIntranet) {
        this.notificarViaIntranet = notificarViaIntranet;
    }

    public boolean isNotificarViaTelaDeBLoqueio() {
        return notificarViaTelaDeBLoqueio;
    }

    public void setNotificarViaTelaDeBLoqueio(boolean notificarViaTelaDeBLoqueio) {
        this.notificarViaTelaDeBLoqueio = notificarViaTelaDeBLoqueio;
    }

    public boolean isNotificarViaMobile() {
        return notificarViaMobile;
    }

    public void setNotificarViaMobile(boolean notificarViaMobile) {
        this.notificarViaMobile = notificarViaMobile;
    }

    public boolean isNotificarViaWhatsapp() {
        return notificarViaWhatsapp;
    }

    public void setNotificarViaWhatsapp(boolean notificarViaWhatsapp) {
        this.notificarViaWhatsapp = notificarViaWhatsapp;
    }

    public boolean isNotificarViaSMS() {
        return notificarViaSMS;
    }

    public void setNotificarViaSMS(boolean notificarViaSMS) {
        this.notificarViaSMS = notificarViaSMS;
    }

    public boolean isNotificarViaEmail() {
        return notificarViaEmail;
    }

    public void setNotificarViaEmail(boolean notificarViaEmail) {
        this.notificarViaEmail = notificarViaEmail;
    }

    public int getMinutosRenotificacao() {
        return minutosRenotificacao;
    }

    public void setMinutosRenotificacao(int minutosRenotificacao) {
        this.minutosRenotificacao = minutosRenotificacao;

    }

    public int getDiasLog() {
        return diasLog;
    }

    public void setDiasLog(int diasLog) {
        this.diasLog = diasLog;
    }

    public boolean isNotificarViaApiPersonalizada() {
        return notificarViaApiPersonalizada;
    }

    public void setNotificarViaApiPersonalizada(boolean notificarViaApiPersonalizada) {
        this.notificarViaApiPersonalizada = notificarViaApiPersonalizada;
    }

    public AcaoDoSistema getAcaoAutoExecucao() {
        return acaoAutoExecucao;
    }

    public void setAcaoAutoExecucao(AcaoDoSistema acaoAutoExecucao) {
        this.acaoAutoExecucao = acaoAutoExecucao;
    }

    public boolean isExigirReciboDeEntrega() {
        return exigirReciboDeEntrega;
    }

    public void setExigirReciboDeEntrega(boolean exigirReciboDeEntrega) {
        this.exigirReciboDeEntrega = exigirReciboDeEntrega;
    }

    public boolean isExigirReciboLeitura() {
        return exigirReciboLeitura;
    }

    public void setExigirReciboLeitura(boolean exigirReciboLeitura) {
        this.exigirReciboLeitura = exigirReciboLeitura;
    }

}
