/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoCampo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campo.FabTipoAtributoObjeto;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@InfoObjetoSB(tags = "Notificação entre Usuários", plural = "Notifcações entre usuários", icone = "fa fa-paper-plane-o", generoFeminino = false)
public class NotificacaoUsrParaUsr extends NotificacaoSB {

    @ManyToOne(targetEntity = UsuarioSB.class)
    @InfoCampo(tipo = FabTipoAtributoObjeto.OBJETO_DE_UMA_LISTA)
    private UsuarioSB usuarioAguardandoResposta;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String textoRespostaAoRemetente;

    @InfoCampo(tipo = FabTipoAtributoObjeto.TEXTO_SIMPLES)
    private String observacao;

    @ManyToOne(targetEntity = AcaoDoSistema.class)
    private AcaoDoSistema acaoPermissaoUsoUnico;

    public UsuarioSB getUsuarioAguardandoResposta() {
        return usuarioAguardandoResposta;
    }

    public void setUsuarioAguardandoResposta(UsuarioSB usuarioAguardandoResposta) {
        this.usuarioAguardandoResposta = usuarioAguardandoResposta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public AcaoDoSistema getAcaoPermissaoUsoUnico() {
        return acaoPermissaoUsoUnico;
    }

    public void setAcaoPermissaoUsoUnico(AcaoDoSistema acaoPermissaoUsoUnico) {
        this.acaoPermissaoUsoUnico = acaoPermissaoUsoUnico;
    }

}
