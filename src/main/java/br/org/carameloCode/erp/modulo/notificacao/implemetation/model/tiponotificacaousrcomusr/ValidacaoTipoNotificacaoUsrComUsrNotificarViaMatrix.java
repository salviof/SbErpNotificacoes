package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadorTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadoresTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValidacaoTipoNotificacaoNotificarViaMatrix;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValidadorTipoNotificacaoUsrComUsr(validador = ValidadoresTipoNotificacaoUsrComUsr.NOTIFICARVIAMATRIX)
public class ValidacaoTipoNotificacaoUsrComUsrNotificarViaMatrix
        extends
        ValidacaoTipoNotificacaoNotificarViaMatrix {

    public ValidacaoTipoNotificacaoUsrComUsrNotificarViaMatrix(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

}
