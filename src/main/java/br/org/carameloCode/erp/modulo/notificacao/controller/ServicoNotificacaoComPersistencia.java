/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.controller;

import br.org.carameloCode.erp.modulo.notificacao.api.ERPNotificacoes;
import br.org.carameloCode.erp.modulo.notificacao.api.ErroGerandoDialogo;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.recibos.leitura.ReciboLeitura;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.transporte.LogDisparoNotificacao;
import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilCRCStringGerador;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.CentralComunicaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfRespostaComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ComoArmazenamentoComunicacao;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import org.coletivojava.fw.api.tratamentoErros.FabErro;

/**
 *
 * @author salvio
 */
public abstract class ServicoNotificacaoComPersistencia extends CentralComunicaoAbstrato {

    protected ComoArmazenamentoComunicacao armazenamento;

    public ServicoNotificacaoComPersistencia() {
        armazenamento = new RepositorioComunicacao();
    }

    @Override
    public ItfDialogo getComnunicacaoRegistrada(String pCodigoComunicacao) {
        ItfDialogo dialogo = super.getComnunicacaoRegistrada(pCodigoComunicacao);
        if (dialogo == null) {
            EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
            try {
                ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
                consulta.addcondicaoCampoIgualA(CPNotificacaoSB.id, Long.valueOf(pCodigoComunicacao));
                NotificacaoSB ntf = consulta.getPrimeiroRegistro();
                if (ntf != null) {
                    ntf.getDisparos().size();
                    try {
                        return ERPNotificacoes.NOTIFICACAO_PADRAO.getImplementacaoDoContexto().gerarDialogoByNotificacao(ntf);
                    } catch (ErroGerandoDialogo ex) {
                        SBCore.RelatarErro(FabErro.LANCAR_EXCECÃO, "Erro procurando Dialogo por código " + pCodigoComunicacao, ex);
                        return null;
                    }
                } else {
                    return null;
                }

            } finally {
                UtilSBPersistencia.fecharEM(em);

            }

        } else {
            return dialogo;
        }

    }

    @Override
    public List<ItfDialogo> getComunicacoesAguardandoRespostaDoDestinatario(ComoUsuario pDestinatario) {
        List<ItfDialogo> comunicacoes = super.getComunicacoesAguardandoRespostaDoDestinatario(pDestinatario);
        return comunicacoes;
    }

    @Override
    public ComoArmazenamentoComunicacao getArmazenamento() {
        return armazenamento;
    }

    @Override
    public boolean responderComunicacao(String codigoSeloComunicacao, ItfRespostaComunicacao pResposta) {

        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ItfDialogo pComunicacao = SBCore.getServicoComunicacao().getArmazenamento().getDialogoByCodigoSelo(codigoSeloComunicacao);

            if (super.responderComunicacao(pComunicacao.getCodigoSelo(), pResposta)) {
                ConsultaDinamicaDeEntidade consulta = new ConsultaDinamicaDeEntidade(NotificacaoSB.class, em);
                consulta.addcondicaoCampoIgualA(CPNotificacaoSB.codigoselocomunicacao, codigoSeloComunicacao);

                NotificacaoSB ntf = consulta.getPrimeiroRegistro();
                if (ntf != null) {
                    if (ntf.getId() != null) {
                        Optional<LogDisparoNotificacao> disparo = ntf.getDisparos().stream()
                                .filter(dp -> dp.getTipoTransporte().equals(ERPTipoCanalComunicacao.INTRANET_MENU)).findFirst();
                        if (disparo.isPresent()) {
                            ReciboLeitura reciboLeitura = new ReciboLeitura();
                            reciboLeitura.setDisparo(disparo.get());
                            reciboLeitura.setCodigoLeitura(UtilCRCStringGerador.getStringRandomicaUUID());
                            reciboLeitura.setDataHoraLeitura(new Date());
                            UtilSBPersistencia.mergeRegistro(reciboLeitura, em);
                        }
                        UtilSBPersistencia.iniciarTransacao(em);
                        String update = "update " + NotificacaoSB.class.getSimpleName() + " SET status_id = " + FabStatusNotificacao.LIDA.getRegistro().getId()
                                + " where id = " + ntf.getId() + ";";
                        return UtilSBPersistencia.executaSQL(em, update);

                    }
                }
                return true;
            } else {
                return false;
            }
        } finally {
            UtilSBPersistencia.finzalizaTransacaoEFechaEM(em);
        }

    }
}
