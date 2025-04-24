/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivojava.erp.notificacao.api.ERPNotificacoes;
import br.org.coletivojava.erp.notificacao.api.ErroGerandoDialogo;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.StatusNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoValorLogico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Notificação", plural = "Notifcações ", icone = "fa fa-fa-bullhorn")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
@GenericGenerator(name = "geradorIdNotificacao",
        strategy = "br.org.coletivojava.erp.notificacao.padrao.model.notificacao.GeradorIdentificacadorNotificacao")
public class NotificacaoSB extends EntidadeSimples {

    @Id

    @GeneratedValue(generator = "geradorIdNotificacao")
    private Long id;

    @InfoCampo(tipo = FabTipoAtributoObjeto.NOME)
    private String nome;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    @InfoCampoValorLogico(nomeCalculo = "Assunto")
    private String assunto;

    @InfoCampo(tipo = FabTipoAtributoObjeto.DESCRITIVO)
    @Column(length = 1500)
    @InfoCampoValorLogico(nomeCalculo = "Conteúdo")
    private String conteudo;

    @Column(length = 8000)
    @InfoCampo(tipo = FabTipoAtributoObjeto.HTML)
    @InfoCampoValorLogico(nomeCalculo = "Conteúdo Html")
    private String conteudoHtml;

    @ManyToOne(targetEntity = UsuarioSB.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private UsuarioSB usuario;

    @ManyToOne(targetEntity = TipoNotificacao.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private TipoNotificacao tipoNotificacao;

    @ManyToOne(targetEntity = StatusNotificacao.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private StatusNotificacao status;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataRegistroNotificacao;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataExpiraNotificacao;

    @OneToMany(mappedBy = "notificacao", targetEntity = LogDisparoNotificacao.class, orphanRemoval = true, cascade = CascadeType.ALL)
    @OrderBy("dataHoraDisparo DESC")
    private List<LogDisparoNotificacao> disparos;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String codigoSeloComunicacao;

    @Transient
    private DialogoNotificacao dialogo;

    public DialogoNotificacao getDialogo() {

        if (id == null) {
            return null;
        }
        try {

            return (DialogoNotificacao) ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().getDialogoByNotificacao(this);
        } catch (ErroGerandoDialogo ex) {
            return null;
        }
    }

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

    public UsuarioSB getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioSB usuario) {
        this.usuario = usuario;
    }

    public TipoNotificacao getTipoNotificacao() {
        return tipoNotificacao;
    }

    public void setTipoNotificacao(TipoNotificacao tipoNotificacao) {
        this.tipoNotificacao = tipoNotificacao;
    }

    public StatusNotificacao getStatus() {
        return status;
    }

    public void setStatus(StatusNotificacao status) {
        this.status = status;
    }

    public Date getDataRegistroNotificacao() {
        return dataRegistroNotificacao;
    }

    public void setDataRegistroNotificacao(Date dataRegistroNotificacao) {
        this.dataRegistroNotificacao = dataRegistroNotificacao;
    }

    public Date getDataExpiraNotificacao() {
        return dataExpiraNotificacao;
    }

    public void setDataExpiraNotificacao(Date dataExpiraNotificacao) {
        this.dataExpiraNotificacao = dataExpiraNotificacao;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getConteudoHtml() {
        return conteudoHtml;
    }

    public void setConteudoHtml(String conteudoHtml) {
        this.conteudoHtml = conteudoHtml;
    }

    public List<LogDisparoNotificacao> getDisparos() {
        return disparos;
    }

    public void setDisparos(List<LogDisparoNotificacao> disparos) {
        this.disparos = disparos;
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

    public String getCodigoSeloComunicacao() {
        return codigoSeloComunicacao;
    }

    public void setCodigoSeloComunicacao(String codigoSeloComunicacao) {
        this.codigoSeloComunicacao = codigoSeloComunicacao;
    }

}
