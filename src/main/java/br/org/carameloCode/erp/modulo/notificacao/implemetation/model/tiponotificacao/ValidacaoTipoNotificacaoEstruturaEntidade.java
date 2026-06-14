package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.CPTipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import com.super_bits.modulosSB.SBCore.modulos.view.widgetsFormulario.FabTipoWidgetFormulario;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.ESTRUTURAENTIDADE)
public class ValidacaoTipoNotificacaoEstruturaEntidade
        extends
        ValidacaoGenerica<TipoNotificacao> {

    public ValidacaoTipoNotificacaoEstruturaEntidade(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public List validar(java.lang.Object o) throws ErroValidacao {
        EstruturaDeEntidade estrutura = (EstruturaDeEntidade) o;

        getTipoNotificacao().setNomeEntidadeReferencia(estrutura.getNomeEntidade());

        return FabTipoWidgetFormulario.getCampos(getTipoNotificacao().getCPinst(CPTipoNotificacao.nomeentidadereferencia));
    }

    public TipoNotificacao getTipoNotificacao() {
        return getObjetoDoAtributo();
    }
}
