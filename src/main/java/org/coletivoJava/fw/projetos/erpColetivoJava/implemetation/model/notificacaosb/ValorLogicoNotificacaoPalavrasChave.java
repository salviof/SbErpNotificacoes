package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.notificacaosb;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao.FabStatusNotificacao;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.stringSubstituicao.MapaSubstituicao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfBeanSimples;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

public class ValorLogicoNotificacaoPalavrasChave extends ValorLogicoCalculoGenerico {

    private final String mascaraValor;

    public ValorLogicoNotificacaoPalavrasChave(ItfCampoInstanciado pCampo, String pMascaraValor) {
        super(pCampo);
        mascaraValor = pMascaraValor;
    }

    @Override
    public Object getValor(Object... pEntidade) {

        if (!getNotificacao().getStatus().equals(FabStatusNotificacao.REGISTRADA.getRegistro())) {
            try {
                return getCampoInst().getMetodoGet().invoke(getCampoInst().getObjetoRaizDoAtributo());
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
                Logger.getLogger(ValorLogicoNotificacaoPalavrasChave.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (mascaraValor == null) {
            return null;
        }
        if (!mascaraValor.contains("[")) {
            setValorPorReflexao(mascaraValor);
            return mascaraValor;
        } else {

            MapaSubstituicao mapaSub = new MapaSubstituicao();
            if (getNotificacao().getTipoNotificacao().getNomeEntidadeReferencia() != null) {
                if (getNotificacao().getCodigoEntidadeRelacionada() != null && getNotificacao().getTipoNotificacao().getNomeEntidadeReferencia() != null) {
                    Class entidade = MapaObjetosProjetoAtual.getClasseDoObjetoByNome(getNotificacao().getTipoNotificacao().getNomeEntidadeReferencia());
                    EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
                    try {
                        ItfBeanSimples item = (ItfBeanSimples) UtilSBPersistencia.getRegistroByID(entidade, Long.valueOf(getNotificacao().getCodigoEntidadeRelacionada()), em);
                        mapaSub.adicionarPalavrasChaveDoObjeto(item);

                    } finally {
                        UtilSBPersistencia.fecharEM(em);
                    }

                }
            }
            String conteudoProcessado = mapaSub.substituirEmString(mascaraValor);
            setValorPorReflexao(conteudoProcessado);
            return conteudoProcessado;

        }

    }

    public NotificacaoSB getNotificacao() {
        return (NotificacaoSB) getCampoInst().getObjetoRaizDoAtributo();
    }
}
