/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.api;

import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import java.util.List;

/**
 *
 * @author salvio
 */
public interface ItfERPNotificacao {

    public NotificacaoSB gerarNotificacao(TipoNotificacao pNotificcao, ComoUsuario pUsuario, ComoEntidadeSimples pObjeto) throws ErroGerandoNotificacao;

    public List<NotificacaoSB> gerarNotificacoes(TipoNotificacao tipo, ComoEntidadeSimples pItem, FabTipoAgenteOrganizacao... pTipoAgentes) throws ErroGerandoNotificacao;

    public default NotificacaoSB gerarNotificacao(TipoNotificacao pNotificcao, ComoUsuario pUsuario) throws ErroGerandoNotificacao {
        return gerarNotificacao(pNotificcao, pUsuario, (ComoEntidadeSimples) null);
    }

    public ItfDialogo gerarDialogoByNotificacao(NotificacaoSB pNotificacao) throws ErroGerandoDialogo;

    public boolean registrarReciboLeitura(String codigoDisparo, String codigoLeitura);

    public boolean registrarReciboLeitura(ERPTipoCanalComunicacao pTipoCanal, String pCodigoNotificacao, String codigoLeitura);

}
