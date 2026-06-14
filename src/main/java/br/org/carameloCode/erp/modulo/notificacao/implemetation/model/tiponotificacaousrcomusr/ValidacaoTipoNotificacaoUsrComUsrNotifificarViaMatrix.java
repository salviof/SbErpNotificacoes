package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacaousrcomusr;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadorTipoNotificacaoUsrComUsr;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacaousrcomusr.ValidadoresTipoNotificacaoUsrComUsr;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorTipoNotificacaoUsrComUsr(validador = ValidadoresTipoNotificacaoUsrComUsr.NOTIFIFICARVIAMATRIX)
public class ValidacaoTipoNotificacaoUsrComUsrNotifificarViaMatrix
		extends
			ValidacaoGenerica<TipoNotificacaoUsrComUsr> {

	public ValidacaoTipoNotificacaoUsrComUsrNotifificarViaMatrix(
			ItfCampoInstanciado pCampo) {
		super(pCampo);
	}

	@Override
	public List validar(java.lang.Object o) throws ErroValidacao {
		CarameloCode.getServicoMensagemFireForget().enviarMsgErroAoUsuario(
				"A Validação do campo  Via Matrix não foi implementada");
		return new ArrayList<>();
	}

	public TipoNotificacaoUsrComUsr getTipoNotificacaoUsrComUsr() {
		return getObjetoDoAtributo();
	}
}