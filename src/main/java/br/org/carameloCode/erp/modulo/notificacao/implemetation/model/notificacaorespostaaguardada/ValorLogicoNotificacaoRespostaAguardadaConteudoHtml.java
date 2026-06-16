package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaorespostaaguardada;

import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValorLogicoNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaorespostaaguardada.ValoresLogicosNotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaosb.CPNotificacaoSB;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoRespostaAguardada;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.statusNotificacao.FabStatusNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.notificacaosb.ValorLogicoNotificacaoPalavrasChave;
import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.SBCore.UtilGeral.stringSubstituicao.MapaSubstituicao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoEntidadeSimples;
import java.lang.reflect.InvocationTargetException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;

@ValorLogicoNotificacaoRespostaAguardada(calculo = ValoresLogicosNotificacaoRespostaAguardada.CONTEUDOHTML)
public class ValorLogicoNotificacaoRespostaAguardadaConteudoHtml
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoNotificacaoRespostaAguardadaConteudoHtml(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public Object getValor(Object... pEntidade) {

        if (!getNotificacaoRespostaAguardada().getStatus().equals(FabStatusNotificacao.REGISTRADA.getRegistro())) {

            return getNotificacaoRespostaAguardada().getConteudoHtml();

        }
        String mascaraValor = "O destinatário respondeu a questão";
        if (getNotificacaoRespostaAguardada().isRespostaPostiva()) {
            mascaraValor = getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getComoTiponotificacaoUsrToUsr().getTextoRespostaPositivo();
        } else {
            mascaraValor = getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getComoTiponotificacaoUsrToUsr().getTextoRespostaNegativo();
        }

        if (mascaraValor == null) {
            return null;
        }
        if (!mascaraValor.contains("[")) {
            setValorPorReflexao(mascaraValor);
            return mascaraValor;
        } else {

            MapaSubstituicao mapaSub = new MapaSubstituicao();
            if (getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getNomeEntidadeReferencia() != null) {
                if (getNotificacaoRespostaAguardada().getNotificacaoOrigem().getCodigoEntidadeRelacionada() != null && getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getNomeEntidadeReferencia() != null) {
                    Class entidade = MapaObjetosProjetoAtual.getClasseDoObjetoByNome(getNotificacaoRespostaAguardada().getNotificacaoOrigem().getTipoNotificacao().getNomeEntidadeReferencia());
                    EntityManager em = UtilSBPersistencia.getEntyManagerPadraoNovo();
                    try {
                        ComoEntidadeSimples item = (ComoEntidadeSimples) UtilSBPersistencia.getRegistroByID(entidade, Long.valueOf(getNotificacaoRespostaAguardada().getNotificacaoOrigem().getCodigoEntidadeRelacionada()), em);
                        mapaSub.adicionarPalavrasChavePorTextoModelo(getNotificacaoRespostaAguardada().getNotificacaoOrigem(), "[destinatario],  [" + CPNotificacaoSB.dataregistronotificacao + "] [" + CPNotificacaoSB.dataexpiranotificacao + "]  [" + CPNotificacaoSB.codigoselocomunicacao + "]");
                        mapaSub.adicionarPalavrasChavePorTextoModelo(item, mascaraValor);
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

    public NotificacaoRespostaAguardada getNotificacaoRespostaAguardada() {
        return (NotificacaoRespostaAguardada) getCampoInst()
                .getObjetoRaizDoAtributo();
    }
}
