/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.api;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTransporteComunicacao;
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

    public String getReciboEntrega(ERPTransporteComunicacao tipoTransporte, Long pCodigoNotificacao);

    public String getReciboLeitura(ERPTransporteComunicacao tipoTransporte, Long pCodigoNotificacao);

    public String registrarReciboEntrega(ERPTransporteComunicacao tipoTransporte, Long pCodigoNotificacao, String codigo);

    public String registrarReciboLeitura(ERPTransporteComunicacao tipoTransporte, Long pCodigoNotificacao, String codigo);

    public NotificacaoSB getNotificacao(TipoNotificacao pNotificcao, ItfUsuario pUsuario, ItfBeanSimples pObjeto);

}
