package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.CPTipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import com.super_bits.modulosSB.SBCore.modulos.view.widgetsFormulario.FabTipoWidgetFormulario;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.ACAOGATILHONOTIFICACAO)
public class ValidacaoTipoNotificacaoAcaoGatilhoNotificacao
        extends
        ValidacaoGenerica<TipoNotificacao> {

    public ValidacaoTipoNotificacaoAcaoGatilhoNotificacao(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public List validar(java.lang.Object o) throws ErroValidacao {
        AcaoDoSistema acaoo = (AcaoDoSistema) o;
        if (o != null) {
            getTipoNotificacao().getAcaoGatilhoNotificacao();
            EstruturaDeEntidade est = MapaObjetosProjetoAtual.getEstruturaObjeto(acaoo.getComoAcaoDeEntidade().getClasseRelacionada());

            if (getTipoNotificacao().getEstruturaEntidade() == null) {
                getTipoNotificacao().setEstruturaEntidade(est);
            }
            if (getTipoNotificacao().getNomeEntidadeReferencia() == null) {
                getTipoNotificacao().setNomeEntidadeReferencia(est.getNomeEntidade());
            }
        }
        return FabTipoWidgetFormulario.getCampos(getTipoNotificacao().getCPinst(CPTipoNotificacao.estruturaentidade), getTipoNotificacao().getCPinst(CPTipoNotificacao.nomeentidadereferencia));
    }

    public TipoNotificacao getTipoNotificacao() {
        return getObjetoDoAtributo();
    }
}
