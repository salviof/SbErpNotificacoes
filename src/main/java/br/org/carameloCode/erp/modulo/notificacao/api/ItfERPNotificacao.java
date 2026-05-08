/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.api;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;

/**
 *
 * @author salvio
 */
public interface ItfERPNotificacao {

    public boolean notificar(TipoNotificacao tipo, ComoEntidadeSimples pItem);

    public ItfDialogo getDialogoByNotificacao(NotificacaoSB pNotificacao) throws ErroGerandoDialogo;

    public String getReciboLeitura(ERPTipoCanalComunicacao tipoTransporte, Long pCodigoNotificacao);

    public String registrarReciboEntrega(ERPTipoCanalComunicacao tipoTransporte, String codigoDisparo, String codigoEntrega);

    public String registrarReciboLeitura(ERPTipoCanalComunicacao tipoTransporte, String codigoDisparo, String codigoLeitura);

    public NotificacaoSB getNotificacao(TipoNotificacao pNotificcao, ComoUsuario pUsuario, ComoEntidadeSimples pObjeto) throws ErroGerandoNotificacao;

}
