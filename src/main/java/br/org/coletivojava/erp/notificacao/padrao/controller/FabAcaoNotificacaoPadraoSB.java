package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulos.SBAcessosModel.controller.FabModulosSistemaSB;
import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.acoesAutomatizadas.FabTipoAutoExecucaoAcao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;

/**
 *
 * @author salvio
 */
@InfoModuloMktNotificacao(modulo = FabModulosSistemaSB.COMUNICACAO)
public enum FabAcaoNotificacaoPadraoSB implements ItfFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = NotificacaoSB.class)
    NOTIFICACAO_MB_GESTAO,
    @InfoTipoAcaoFormulario()
    NOTIFICACAO_FRM_LISTAR,
    @InfoTipoAcaoController
    NOTIFICACAO_CTR_REGISTRAR_NOTIFICACAO,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.MINUTOS_A_CADA_1)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_ENVIO_AUTO_EXEC,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.MINUTOS_A_CADA_5)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_LEITURA_AUTO_EXEC,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.DIARIO_MEIA_NOITE)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_LIMPEZA_AUTO_EXEC;

}
