/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao;

import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeNormal;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ItfEntidadeExtensivel;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Tipo de Notificação"}, plural = "Tipos de Notificação", icone = "fa fa-bullhorn")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
public class TipoNotificacao extends EntidadeNormal implements ItfEntidadeExtensivel {

    @Id
    @GenericGenerator(
            name = "geradorIdDuploControle",
            strategy = "com.super_bits.modulosSB.Persistencia.geradorDeId.GeradorIdDuploControleIncremental"
    )
    @GeneratedValue(generator = "geradorIdDuploControle")
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME, somenteLeitura = true)
    private String nome;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @Column(columnDefinition = "VARCHAR(300) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String assunto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML_TEMPLATE)
    @Column(columnDefinition = "VARCHAR(8000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci")
    private String conteudoHTML;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoGatilhoNotificacao;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoAutoExecucaoEnvio;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoAutoExecucaoEntrega;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoAutoExecucaoLeitura;

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

    @InfoCampo(tipo = FabTipoAtributoObjeto.REG_ATIVO_INATIVO)
    @InfoCampoVerdadeiroOuFalso
    private boolean ativo = true;

    private String nomeEntidadeReferencia;

    @Transient
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA, caminhoParaLista = "entidadesDisponiveis")
    private EstruturaDeEntidade estruturaEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.LISTA_OBJETOS_PUBLICOS)
    @InfoCampoValorLogico(nomeCalculo = "EStruturas disponiveis")
    @Transient
    private List<EstruturaDeEntidade> entidadesDisponiveis;

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

    public String getConteudoHTML() {
        return conteudoHTML;
    }

    public void setConteudoHTML(String conteudoHTML) {
        this.conteudoHTML = conteudoHTML;
    }

    public AcaoDoSistema getAcaoGatilhoNotificacao() {
        return acaoGatilhoNotificacao;
    }

    public void setAcaoGatilhoNotificacao(AcaoDoSistema acaoGatilhoNotificacao) {
        this.acaoGatilhoNotificacao = acaoGatilhoNotificacao;
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

    public AcaoDoSistema getAcaoAutoExecucaoEnvio() {
        return acaoAutoExecucaoEnvio;
    }

    public void setAcaoAutoExecucaoEnvio(AcaoDoSistema acaoAutoExecucaoEnvio) {
        this.acaoAutoExecucaoEnvio = acaoAutoExecucaoEnvio;
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

    public AcaoDoSistema getAcaoAutoExecucaoEntrega() {
        return acaoAutoExecucaoEntrega;
    }

    public void setAcaoAutoExecucaoEntrega(AcaoDoSistema acaoAutoExecucaoEntrega) {
        this.acaoAutoExecucaoEntrega = acaoAutoExecucaoEntrega;
    }

    public AcaoDoSistema getAcaoAutoExecucaoLeitura() {
        return acaoAutoExecucaoLeitura;
    }

    public void setAcaoAutoExecucaoLeitura(AcaoDoSistema acaoAutoExecucaoLeitura) {
        this.acaoAutoExecucaoLeitura = acaoAutoExecucaoLeitura;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public boolean isEntidadeExtendida() {
        return false;
    }

    public String getNomeEntidadeReferencia() {
        return nomeEntidadeReferencia;
    }

    public void setNomeEntidadeReferencia(String nomeEntidadeReferencia) {
        this.nomeEntidadeReferencia = nomeEntidadeReferencia;
    }

    public EstruturaDeEntidade getEstruturaEntidade() {
        return estruturaEntidade;
    }

    public void setEstruturaEntidade(EstruturaDeEntidade estruturaEntidade) {
        this.estruturaEntidade = estruturaEntidade;
    }

    public List<EstruturaDeEntidade> getEntidadesDisponiveis() {
        return entidadesDisponiveis;
    }

    public void setEntidadesDisponiveis(List<EstruturaDeEntidade> entidadesDisponiveis) {
        this.entidadesDisponiveis = entidadesDisponiveis;
    }

}
