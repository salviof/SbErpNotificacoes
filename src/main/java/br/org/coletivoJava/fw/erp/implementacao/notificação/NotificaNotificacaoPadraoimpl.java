package br.org.coletivoJava.fw.erp.implementacao.notificação;

import br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.notificação.NotificaNotificacaoPadrao;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.FabStatusNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.UsuarioSB;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@NotificaNotificacaoPadrao
public class NotificaNotificacaoPadraoimpl
        extends
        RepositorioLinkEntidadesGenerico
        implements
        br.org.coletivojava.erp.notificacao.api.ItfERPNotificacao {

    @Override
    public String getReciboEntrega(
            ERPTipoCanalComunicacao erpTransporteComunicacao, Long l) {
        return null;
    }

    @Override
    public String registrarReciboEntrega(
            br.org.coletivojava.erp.comunicacao.transporte.ERPTipoCanalComunicacao erpTransporteComunicacao,
            Long l, String s) {
        return null;
    }

    @Override
    public String registrarReciboLeitura(ERPTipoCanalComunicacao erpTransporteComunicacao,
            Long l, String s) {
        return null;
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
    public NotificacaoSB getNotificacao(TipoNotificacao pNotificcao, ItfUsuario pUsuario, ItfBeanSimples pObjeto) {

        NotificacaoSB notificacao = new NotificacaoSB();
        notificacao.setTipoNotificacao(pNotificcao);
        notificacao.setUsuario((UsuarioSB) pUsuario);
        notificacao.setStatus(FabStatusNotificacao.REGISTRADA.getRegistro());

        notificacao = UtilSBPersistencia.mergeRegistro(notificacao);

        return notificacao;
    }
}
