/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioAplicacaoEmExecucao;

/**
 *
 * @author salvio
 */
public class DialogoNotificacao extends ComunicacaoTransient {

    public DialogoNotificacao(NotificacaoSB pNotificacao) {
        super(new UsuarioAplicacaoEmExecucao(), pNotificacao.getUsuario(),
                FabTipoComunicacao.NOTIFICAR.getRegistro());
    }

}
