package br.org.coletivojava.erp.notificacao.padrao.controller;

import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulos.SBAcessosModel.controller.FabModulosSistemaSB;
import com.super_bits.modulos.SBAcessosModel.fabricas.ItfFabricaDeAcoesPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.acoesAutomatizadas.FabTipoAutoExecucaoAcao;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoController;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoFormulario;
import com.super_bits.modulosSB.SBCore.modulos.Controller.anotacoes.InfoTipoAcaoGestaoEntidade;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao.CPTipoNotificacao;

/**
 *
 * @author salvio
 */
@InfoModuloMktNotificacao(modulo = FabModulosSistemaSB.COMUNICACAO)
public enum FabAcaoNotificacaoPadraoSB implements ItfFabricaDeAcoesPersistencia {

    @InfoTipoAcaoGestaoEntidade(entidade = NotificacaoSB.class, icone = "fa fa-paper-o")
    NOTIFICACAO_MB_GESTAO,
    @InfoTipoAcaoFormulario(nomeAcao = "Listar notificações", icone = "fa ffa-paper-o")
    NOTIFICACAO_FRM_LISTAR,
    @InfoTipoAcaoController
    NOTIFICACAO_CTR_REGISTRAR_NOTIFICACAO,
    @InfoTipoAcaoController
    NOTIFICACAO_CTR_ENVIAR_NOTIFICACAO_REGISTRADA,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.MINUTOS_A_CADA_1)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_ENVIO_AUTO_EXEC,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.MINUTOS_A_CADA_5)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_LEITURA_AUTO_EXEC,
    @InfoTipoAcaoController(autoExecucao = FabTipoAutoExecucaoAcao.DIARIO_MEIA_NOITE)
    NOTIFICACAO_CTR_PROCESSAR_NOTIFICACOES_AGUARDANDO_LIMPEZA_AUTO_EXEC,
    @InfoTipoAcaoGestaoEntidade(nomeAcao = "Tipos de Notificação", icone = "fa fa-bullhorn", entidade = TipoNotificacao.class)
    TIPO_NOTIFICACAO_MB_GESTAO,
    @InfoTipoAcaoFormulario(nomeAcao = "Listar Tipos de Notificação", icone = "fa ffa-paper-plane-o")
    TIPO_NOTIFICACAO_FRM_LISTAR,
    @InfoTipoAcaoFormulario(campos = {"[separador: Identificação]", CPTipoNotificacao.nome, "[separador: Conteúdo]",
        CPTipoNotificacao.assunto, CPTipoNotificacao.conteudohtml,
        "[separador: Entidade Relacionada]", CPTipoNotificacao.estruturaentidade,
        "[separador: Estratégia de notificação]",
        CPTipoNotificacao.notificacaounica, CPTipoNotificacao.ativo, CPTipoNotificacao.exigirrecibodeentrega, CPTipoNotificacao.exigirreciboleitura,
        "[separador: Mídias de notificação]",
        CPTipoNotificacao.notificarviaapipersonalizada, CPTipoNotificacao.notificarviaemail, CPTipoNotificacao.notificarviaintranet, CPTipoNotificacao.notificarviamobile, CPTipoNotificacao.notificarviasms,
        CPTipoNotificacao.notificarviateladebloqueio, CPTipoNotificacao.notificarviawhatsapp, CPTipoNotificacao.notifificarviamatrix

    }
    )
    TIPO_NOTIFICACAO_FRM_EDITAR,
    @InfoTipoAcaoFormulario()
    TIPO_NOTIFICACAO_FRM_VISUALIZAR,
    @InfoTipoAcaoController()
    TIPO_NOTIFICACAO_CTR_SALVAR_MERGE,

}
