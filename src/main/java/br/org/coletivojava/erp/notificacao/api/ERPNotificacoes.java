/*
 *  Desenvolvido pela equipe Super-Bits.com CNPJ 20.019.971/0001-90

 */
package br.org.coletivojava.erp.notificacao.api;

import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfTipoTransporteComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.TipoTransporteSBNativo;

import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import com.super_bits.modulosSB.SBCore.modulos.erp.ApiERPColetivoJavaFW;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItffabricaTrasporteComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.erp.ItfApiErpSuperBits;
import org.coletivojava.fw.utilCoreBase.UtilSBCoreReflexaoAPIERP;

/**
 *
 * @author desenvolvedor
 */
@ApiERPColetivoJavaFW(descricaoApi = "Apis de notificacao", nomeApi = "Notificação", slugInicial = "Notifica")
public enum ERPNotificacoes implements ItfApiErpSuperBits<ItfERPNotificacao> {

    NOTIFICACAO_PADRAO;

    @Override
    public ItfTipoNotificacao getRegistro() {
        return (ItfTipoNotificacao) ItfApiErpSuperBits.super.getRegistro();

    }

    @Override
    public ItfERPNotificacao getImplementacaoDoContexto() {
        return (ItfERPNotificacao) UtilSBCoreReflexaoAPIERP.getImplementacaoDoContexto(this);
    }

    @Override
    public Class getInterface() {
        return ItfERPNotificacao.class;

    }

}
