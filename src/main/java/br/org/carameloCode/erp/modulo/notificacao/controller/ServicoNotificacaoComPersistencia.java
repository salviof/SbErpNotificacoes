/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.CentralComunicaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoArmazenamentoComunicacao;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

/**
 *
 * @author salvio
 */
public abstract class ServicoNotificacaoComPersistencia extends CentralComunicaoAbstrato {

    @Override
    public ItfDialogo gerarComunicacaoUsuario_Usuario(FabTipoComunicacao tipocomunicacao, ComoUsuario pUsuarioRemetente, ComoUsuario pUsuarioDestinatario, String pAssunto, String mensagem) {

        return super.gerarComunicacaoUsuario_Usuario(tipocomunicacao, pUsuarioRemetente, pUsuarioDestinatario, pAssunto, mensagem);
    }

    @Override
    public ItfDialogo gerarComunicacaoSistema_Usuario(FabTipoComunicacao tipocomunicacao, ComoUsuario pUsuario, String pAssunto, String mensagem) {
        return super.gerarComunicacaoSistema_Usuario(tipocomunicacao, pUsuario, pAssunto, mensagem);
    }

    protected ComoArmazenamentoComunicacao armazenamento;

    public ServicoNotificacaoComPersistencia() {
        armazenamento = new RepositorioComunicacao();
    }

    @Override
    public ComoArmazenamentoComunicacao getArmazenamento() {
        return armazenamento;
    }

    @Override
    public boolean responderComunicacao(String codigoSeloComunicacao, ItfRespostaComunicacao pResposta, final ERPTipoCanalComunicacao pCanal) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {

            ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
            consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, codigoSeloComunicacao);
            NotificacaoSB ntf = consulta.getPrimeiroRegistro();
            if (ntf != null) {
                if (ntf.getId() != null) {
                    Optional<LogDisparoNotificacao> pesquisadisparo = ntf.getDisparos().stream()
                            .filter(dp -> dp.getTipoTransporte().equals(pCanal)).findFirst();
                    if (pesquisadisparo.isPresent()) {
                        LogDisparoNotificacao disparo = pesquisadisparo.get();
                        return ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().registrarReciboLeitura(disparo.getCodigoRegistroEnvio(), UtilCRCStringGerador.getStringRandomicaUUID());
                    }
                }
            }
            return true;

        } finally {
            UtilSBPersistencia.fecharEM(em);
        }

    }

    @Override
    public List<ItfDialogo> getNotificacoesAtivasMenu() {
        return getArmazenamento().getDialogos(CarameloCode.getServicoSessao().getSessaoAtual().getUsuario(), ERPTipoCanalComunicacao.INTRANET_MENU);
    }

    @Override
    public List<ItfDialogo> getNotificacoesAtivasBloqueioTela() {
        return getArmazenamento().getDialogos(CarameloCode.getServicoSessao().getSessaoAtual().getUsuario(), ERPTipoCanalComunicacao.INTRANET_BLOQUEIO_TELA);
    }
}
