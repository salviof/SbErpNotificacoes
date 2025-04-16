/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.api;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

/**
 *
 * @author salvio
 */
public interface ItfERPNotificacao {

    public boolean notificar(TipoNotificacao tipo, ItfBeanSimples pItem);

    public String getReciboEntrega(ERPTipoCanalComunicacao tipoTransporte, Long pCodigoNotificacao);

    public String getReciboLeitura(ERPTipoCanalComunicacao tipoTransporte, Long pCodigoNotificacao);

    public String registrarReciboEntrega(ERPTipoCanalComunicacao tipoTransporte, Long pCodigoNotificacao, String codigo);

    public String registrarReciboLeitura(ERPTipoCanalComunicacao tipoTransporte, Long pCodigoNotificacao, String codigo);

    public NotificacaoSB getNotificacao(TipoNotificacao pNotificcao, ItfUsuario pUsuario, ItfBeanSimples pObjeto);

}
