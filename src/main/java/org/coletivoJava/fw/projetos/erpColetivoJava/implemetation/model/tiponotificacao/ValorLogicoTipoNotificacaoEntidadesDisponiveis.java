package org.coletivoJava.fw.projetos.erpColetivoJava.implemetation.model.tiponotificacao;

import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.calculos.ValorLogicoCalculoGenerico;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao.ValorLogicoTipoNotificacao;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import java.util.List;

@ValorLogicoTipoNotificacao(calculo = ValoresLogicosTipoNotificacao.ENTIDADESDISPONIVEIS)
public class ValorLogicoTipoNotificacaoEntidadesDisponiveis
        extends
        ValorLogicoCalculoGenerico {

    public ValorLogicoTipoNotificacaoEntidadesDisponiveis(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    private List<EstruturaDeEntidade> estrutura;

    @Override
    public Object getValor(Object... pEntidade) {

        if (estrutura == null) {
            estrutura = MapaObjetosProjetoAtual.getListaTodosEstruturaObjeto();
            getTipoNotificacao().setEntidadesDisponiveis(estrutura);
        }
        return getTipoNotificacao().getEntidadesDisponiveis();
    }

    public TipoNotificacao getTipoNotificacao() {
        return (TipoNotificacao) getCampoInst().getObjetoDoAtributo();
    }

}
