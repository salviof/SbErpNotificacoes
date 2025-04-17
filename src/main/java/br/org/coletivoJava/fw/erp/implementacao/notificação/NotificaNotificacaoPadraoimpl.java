package br.org.coletivoJava.fw.erp.implementacao.notificação;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.notificação.NotificaNotificacaoPadrao;
import br.org.coletivojava.erp.notificacao.api.ErroGerandoDialogo;
import br.org.coletivojava.erp.notificacao.api.ErroGerandoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.DialogoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.recibos.leitura.ReciboLeitura;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.FabStatusNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.transporte.LogDisparoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.dao.consultaDinamica.ConsultaDinamicaDeEntidade;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.TratamentoDeErros.ErroRegraDeNegocio;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroRegistrandoDialogo;
import com.super_bits.modulosSB.SBCore.modulos.servicosCore.ErroSelandoDialogo;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.coletivojava.fw.api.tratamentoErros.ErroPreparandoObjeto;

@NotificaNotificacaoPadrao
public class NotificaNotificacaoPadraoimpl
        extends
        RepositorioLinkEntidadesGenerico
        implements
        br.org.coletivojava.erp.notificacao.api.ItfERPNotificacao {

    @Override
    public String registrarReciboEntrega(
            br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao erpTransporteComunicacao,
            String pCodigoDisparo, String pCodigoEntrega) {
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consutla = new ConsultaDinamicaDeEntidade(LogDisparoNotificacao.class, em);
            consutla.addcondicaoCampoIgualA("codigoRegistroEnvio", pCodigoDisparo);
            LogDisparoNotificacao log = (LogDisparoNotificacao) consutla.getPrimeiroRegistro();
            if (log.getReciboLeitura() != null) {
                log.setFoiLido(true);
                UtilSBPersistencia.mergeRegistro(log);
            }
            ItfDialogo dialog = SBCore.getServicoComunicacao().getComnunicacaoRegistrada(log.getNotificacao().getCodigoSeloComunicacao());
            SBCore.getServicoComunicacao().responderComunicacao(log.getCodigoRegistroEnvio(), dialog.getRepostasPossiveis().get(0));
            ReciboLeitura recibo = new ReciboLeitura();
            recibo.setCodigoLeitura(pCodigoDisparo);
            recibo.setDisparo(log);
            recibo.setDataHoraLeitura(new Date());
            log.setReciboLeitura(recibo);
            UtilSBPersistencia.mergeRegistro(log, em);
            return pCodigoDisparo;
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
    }

    @Override
    public String registrarReciboLeitura(ERPTipoCanalComunicacao erpTransporteComunicacao,
            String pCodigoDisparo, String pCodigoLeitura) {
        EntityManager em = UtilSBPersistencia.getEMPadraoNovo();
        try {
            ConsultaDinamicaDeEntidade consutla = new ConsultaDinamicaDeEntidade(LogDisparoNotificacao.class, em);
            consutla.addcondicaoCampoIgualA("codigoRegistroEnvio", pCodigoDisparo);
            LogDisparoNotificacao log = (LogDisparoNotificacao) consutla.getPrimeiroRegistro();
            if (log.getReciboLeitura() != null) {
                log.setFoiLido(true);
                UtilSBPersistencia.mergeRegistro(log);
            }
            ItfDialogo dialog = SBCore.getServicoComunicacao().getComnunicacaoRegistrada(log.getNotificacao().getCodigoSeloComunicacao());
            SBCore.getServicoComunicacao().responderComunicacao(log.getCodigoRegistroEnvio(), dialog.getRepostasPossiveis().get(0));
            ReciboLeitura recibo = new ReciboLeitura();
            recibo.setCodigoLeitura(pCodigoDisparo);
            recibo.setDisparo(log);
            recibo.setDataHoraLeitura(new Date());
            log.setReciboLeitura(recibo);
            UtilSBPersistencia.mergeRegistro(log, em);
            return pCodigoDisparo;
        } finally {
            UtilSBPersistencia.fecharEM(em);
        }
    }

    @Override
    public boolean notificar(TipoNotificacao tipoNotificacao,
            ItfBeanSimples itfBeanSimples) {
        return false;
    }

    @Override
    public String getReciboLeitura(
            ERPTipoCanalComunicacao erpTransporteComunicacao,
            java.lang.Long l) {
        return null;
    }

    @Override
    public NotificacaoSB getNotificacao(TipoNotificacao pNotificcao, ItfUsuario pUsuario, ItfBeanSimples pObjeto) throws ErroGerandoNotificacao {

        NotificacaoSB notificacao = new NotificacaoSB();
        notificacao.setTipoNotificacao(pNotificcao);
        notificacao.setUsuario((UsuarioSB) pUsuario);
        notificacao.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());

        return notificacao;
    }

    @Override
    public ItfDialogo getDialogoByNotificacao(NotificacaoSB pNotificacao) throws ErroGerandoDialogo {
        if (pNotificacao.getId() == null) {
            throw new ErroGerandoDialogo("O Id da notificação não foi definido");
        }

        ItfDialogo dialogo = SBCore.getServicoComunicacao().getComnunicacaoRegistrada(Long.toString(pNotificacao.getId()));
        if (dialogo == null) {
            dialogo = new DialogoNotificacao(pNotificacao);
            try {
                SBCore.getServicoComunicacao().registrarDialogo(Long.toString(pNotificacao.getId()), dialogo);
            } catch (ErroRegistrandoDialogo ex) {
                throw new ErroGerandoDialogo("FAlha registrando dialogo");
            }
        }
        return dialogo;

    }
}
