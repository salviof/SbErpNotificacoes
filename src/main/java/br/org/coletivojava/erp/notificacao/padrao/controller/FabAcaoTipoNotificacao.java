/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
public enum FabAcaoTipoNotificacao {

    @InfoTipoAcaoGestaoEntidade(entidade = NotificacaoSB.class)
    NOTIFICACAO_MB_GESTAO,
    NOTIFICACAO_FRM_LISTAR,
    NOTIFICACAO_CTR_NOTIFICAR
}
