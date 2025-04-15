/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTransporteComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.TransporteNotificacao;
import com.super_bits.modulos.SBAcessosModel.controller.resposta.RespostaComGestaoEMRegraDeNegocioPadrao;
import com.super_bits.modulosSB.Persistencia.dao.ControllerAbstratoSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfResposta;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.ItfRespostaAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;

/**
 *
 * @author salvio
 */
public class ModuloNotificacao extends ControllerAbstratoSBPersistencia {

    public static ItfRespostaAcaoDoSistema notificar(NotificacaoSB pNotificacao) {
        return new RespostaComGestaoEMRegraDeNegocioPadrao(getNovaRespostaAutorizaChecaNulo(pNotificacao), pNotificacao) {
            @Override
            public void regraDeNegocio() throws ErroRegraDeNegocio {

                ERPTransporteComunicacao.EMAIL.getImplementacaoDoContexto().dispararInicioComunicacao(pComunicacao);
                TransporteNotificacao transporte = new TransporteNotificacao();
                transporte.setTipoTransporte(ERPTransporteComunicacao.EMAIL);
                transporte.setFoiEnviado(true);
                transporte.setNotificacao(pNotificacao);
                atualizarEntidade(transporte, true);

            }
        };

    }
}
