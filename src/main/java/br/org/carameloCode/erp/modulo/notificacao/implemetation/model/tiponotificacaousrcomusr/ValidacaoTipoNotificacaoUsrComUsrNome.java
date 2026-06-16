package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadorTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadoresTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValidacaoTipoNotificacaoNome;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorTipoNotificacaoUsrComUsr(validador = ValidadoresTipoNotificacaoUsrComUsr.NOME)
public class ValidacaoTipoNotificacaoUsrComUsrNome
        extends
        ValidacaoTipoNotificacaoNome {

    public ValidacaoTipoNotificacaoUsrComUsrNome(ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public TipoNotificacaoUsrComUsr getTipoNotificacaoUsrComUsr() {
        return (TipoNotificacaoUsrComUsr) getObjetoDoAtributo();
    }
}
