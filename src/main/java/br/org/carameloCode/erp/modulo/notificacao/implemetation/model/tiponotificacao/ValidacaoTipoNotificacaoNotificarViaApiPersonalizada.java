package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.NOTIFICARVIAAPIPERSONALIZADA)
public class ValidacaoTipoNotificacaoNotificarViaApiPersonalizada
        extends
        ValidacaoGenerica<TipoNotificacao> {

    public ValidacaoTipoNotificacaoNotificarViaApiPersonalizada(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public List validar(java.lang.Object o) throws ErroValidacao {
        boolean valor = (boolean) o;
        if (valor) {
            if (!ERPTipoCanalComunicacao.API_PERSONALIZADA.isTipoTransporteImplementado()) {
                throw new ErroValidacao("Importe a depedencia:  com implementação para para RPTipoCanalComunicacao.API_PERSONALIZADA para  implementar esse tipo de disparo ");
            }
        }
        return new ArrayList<>();
    }

    public TipoNotificacao getTipoNotificacao() {
        return getObjetoDoAtributo();
    }
}
