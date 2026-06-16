/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao;

import com.super_bits.modulosSB.Persistencia.geradorDeId.GeradorIdDuploControleIncremental;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampoVerdadeiroOuFalso;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;

/**
 *
 * @author salvio
 */
@Entity
@InfoObjetoSB(tags = {"Tipo de Notificação "}, plural = "Tipos de Notificação", icone = "fa fa-bullhorn")
public class TipoNotificacaoUsrComUsr extends TipoNotificacao {

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES, label = "Caminho usuario rementente ", descricao = "Ex: Pedido.criador")
    private String caminhoUsuarioRemetente;

    @InfoCampo(tipo = FabTipoAtributoObjeto.VERDADEIRO_FALSO)
    @InfoCampoVerdadeiroOuFalso()
    private boolean notificarDestinatario;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String textoRespostaPositivo;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String textoRespostaNegativo;

    public boolean isNotificarDestinatario() {

        return notificarDestinatario;
    }

    public void setNotificarDestinatario(boolean notificarDestinatario) {
        this.notificarDestinatario = notificarDestinatario;
    }

    public String getTextoRespostaPositivo() {
        return textoRespostaPositivo;
    }

    public void setTextoRespostaPositivo(String textoRespostaPositivo) {
        this.textoRespostaPositivo = textoRespostaPositivo;
    }

    public String getTextoRespostaNegativo() {
        return textoRespostaNegativo;
    }

    public void setTextoRespostaNegativo(String textoRespostaNegativo) {
        this.textoRespostaNegativo = textoRespostaNegativo;
    }

    public String getCaminhoUsuarioRemetente() {
        return caminhoUsuarioRemetente;
    }

    public void setCaminhoUsuarioRemetente(String caminhoUsuarioRemetente) {
        this.caminhoUsuarioRemetente = caminhoUsuarioRemetente;
    }

    @Override
    public String nomeSequenciaIdentificacao() {
        return TipoNotificacao.class.getSimpleName();
    }

    @Override
    public Long getIdSequenciaInicial() {
        return 1l;
    }

    @Override
    public boolean isEntidadeExtendida() {
        return true;
    }

}
