package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;
import com.super_bits.modulosSB.SBCore.modulos.view.widgetsFormulario.WidgetsFormulario;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.ACAORESPOSTAPERSONALIZADA)
public class ValidacaoTipoNotificacaoAcaoRespostaPersonalizada
        extends
        ValidacaoGenerica<TipoNotificacao> {

    public ValidacaoTipoNotificacaoAcaoRespostaPersonalizada(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public List<WidgetsFormulario> validar(Object pValor) throws ErroValidacao {

        if (pValor != null) {
            AcaoDoSistema acaoo = (AcaoDoSistema) pValor;
            getTipoNotificacao().getAcaoGatilhoNotificacao();
            getTipoNotificacao().setNomeFabricaAcaoRespostaPersonalizada(acaoo.getNomeUnico());

        }
        return new ArrayList<>();
    }

    public TipoNotificacao getTipoNotificacao() {
        return getObjetoDoAtributo();
    }
}
