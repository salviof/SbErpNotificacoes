package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadorTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadoresTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao.ValidacaoTipoNotificacaoCaminhoUsuarioDestinatario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;

@ValidadorTipoNotificacaoUsrComUsr(validador = ValidadoresTipoNotificacaoUsrComUsr.CAMINHOUSUARIODESTINATARIO)
public class ValidacaoTipoNotificacaoUsrComUsrCaminhoUsuarioDestinatario
        extends
        ValidacaoTipoNotificacaoCaminhoUsuarioDestinatario {

    public ValidacaoTipoNotificacaoUsrComUsrCaminhoUsuarioDestinatario(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    public TipoNotificacaoUsrComUsr getTipoNotificacaoUsrComUsr() {
        return (TipoNotificacaoUsrComUsr) getObjetoDoAtributo();
    }
}
