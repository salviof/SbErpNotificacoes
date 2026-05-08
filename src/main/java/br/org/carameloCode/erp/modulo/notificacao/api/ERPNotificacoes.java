/*
 *  Desenvolvido pela equipe Super-Bits.com CNPJ 20.019.971/0001-90

 */
package br.org.carameloCode.erp.modulo.notificacao.api;

import com.super_bits.modulosSB.SBCore.modulos.erp.InfoApiERPCarameloCode;
import com.super_bits.modulosSB.SBCore.modulos.erp.ItfApiErpSuperBits;
import org.coletivojava.fw.utilCoreBase.UtilCRCReflexaoAPIERP;

/**
 *
 * @author desenvolvedor
 */
@InfoApiERPCarameloCode(descricaoApi = "Apis de notificacao", nomeApi = "Notificação", slugInicial = "Notifica")
public enum ERPNotificacoes implements ItfApiErpSuperBits<ItfERPNotificacao> {

    NOTIFICACAO_PADRAO;

    @Override
    public ItfTipoNotificacao getRegistro() {
        return (ItfTipoNotificacao) ItfApiErpSuperBits.super.getRegistro();

    }

    @Override
    public ItfERPNotificacao getImplementacaoDoContexto() {
        return (ItfERPNotificacao) UtilCRCReflexaoAPIERP.getImplementacaoDoContexto(this);
    }

    @Override
    public Class getInterface() {
        return ItfERPNotificacao.class;

    }

}
