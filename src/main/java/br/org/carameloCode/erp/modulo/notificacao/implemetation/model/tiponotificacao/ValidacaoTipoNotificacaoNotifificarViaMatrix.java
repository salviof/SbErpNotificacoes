package br.org.carameloCode.erp.modulo.notificacao.implemetation.model.tiponotificacao;

import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ValidacaoGenerica;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadorTipoNotificacao;
import br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao.ValidadoresTipoNotificacao;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import java.util.ArrayList;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ERPTipoCanalComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.campoInstanciado.ItfCampoInstanciado;
import java.util.List;
import com.super_bits.modulosSB.SBCore.modulos.objetos.validador.ErroValidacao;

@ValidadorTipoNotificacao(validador = ValidadoresTipoNotificacao.NOTIFIFICARVIAMATRIX)
public class ValidacaoTipoNotificacaoNotifificarViaMatrix
        extends
        ValidacaoGenerica<TipoNotificacao> {

    public ValidacaoTipoNotificacaoNotifificarViaMatrix(
            ItfCampoInstanciado pCampo) {
        super(pCampo);
    }

    @Override
    public List validar(java.lang.Object o) throws ErroValidacao {
        boolean valor = (boolean) o;
        if (valor) {
            if (!ERPTipoCanalComunicacao.MATRIX.isTipoTransporteImplementado()) {
                throw new ErroValidacao("Importe o pacote para implementar esse tipo de disparo br.org.coletivoJava.fw.api.erp.comunicacao.canais.SbErpTipoCanalMatrix");
            }
        }
        return new ArrayList<>();
    }

    public TipoNotificacao getTipoNotificacao() {
        return getObjetoDoAtributo();
    }
}
