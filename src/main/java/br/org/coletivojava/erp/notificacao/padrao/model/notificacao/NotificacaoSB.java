/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.StatusNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.TransporteNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimples;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.ListenerEntidadePadrao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = "Notificação", plural = "Notifcações ", icone = "fa fa-fa-bullhorn")

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoEntidade")
@EntityListeners(ListenerEntidadePadrao.class)
public class NotificacaoSB extends EntidadeSimples {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, updatable = false, insertable = false)
    private String tipoEntidade;

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
    private Date dataEnvioNotificacao;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataExpiraNotificacao;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataEntregaNotificacao;

    @Temporal(TemporalType.TIMESTAMP)
    @InfoCampo(tipo = FabTipoAtributoObjeto.DATAHORA)
    private Date dataConfirmacaoLeitura;

    @OneToMany(mappedBy = "notificacao", targetEntity = TransporteNotificacao.class, orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TransporteNotificacao> disparos;

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

    public Date getDataEnvioNotificacao() {
        return dataEnvioNotificacao;
    }

    public void setDataEnvioNotificacao(Date dataEnvioNotificacao) {
        this.dataEnvioNotificacao = dataEnvioNotificacao;
    }

    public Date getDataExpiraNotificacao() {
        return dataExpiraNotificacao;
    }

    public void setDataExpiraNotificacao(Date dataExpiraNotificacao) {
        this.dataExpiraNotificacao = dataExpiraNotificacao;
    }

    public Date getDataEntregaNotificacao() {
        return dataEntregaNotificacao;
    }

    public void setDataEntregaNotificacao(Date dataEntregaNotificacao) {
        this.dataEntregaNotificacao = dataEntregaNotificacao;
    }

    public Date getDataConfirmacaoLeitura() {
        return dataConfirmacaoLeitura;
    }

    public void setDataConfirmacaoLeitura(Date dataConfirmacaoLeitura) {
        this.dataConfirmacaoLeitura = dataConfirmacaoLeitura;
    }

}
