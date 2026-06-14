package br.org.carameloCode.erp.modulo.notificacao.api.model.tiponotificacao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@InfoReferenciaEntidade(tipoObjeto = TipoNotificacao.class)
public enum CPTipoNotificacao {
	_ID, _TIPOENTIDADE, _NOME, _ASSUNTO, _CONTEUDOHTML, _ACAOGATILHONOTIFICACAO, _NOMEFABRICAGATILHONOTICAO, _ACAOAUTOEXECUCAOENVIO, _NOMEFABRICAGATILHOACAOENVIADA, _ACAOAUTOEXECUCAOENTREGA, _NOMEFABRICAGATILHOACAOENTREGA, _ACAOAUTOEXECUCAOLEITURA, _NOMEFABRICAGATILHOACAOLEITURA, _EXIGIRRECIBODEENTREGA, _EXIGIRRECIBOLEITURA, _NOTIFICACAOUNICA, _NOTIFIFICARVIAMATRIX, _NOTIFICARVIAMENU, _NOTIFICARVIATELADEBLOQUEIO, _NOTIFICARVIAMOBILE, _NOTIFICARVIAWHATSAPP, _NOTIFICARVIAAPIPERSONALIZADA, _NOTIFICARVIASMS, _NOTIFICARVIAEMAIL, _REMETENTEAGUARDARESPOSTA, _MINUTOSRENOTIFICACAO, _DIASLOG, _ATIVO, _NOMEENTIDADEREFERENCIA, _CAMINHOUSUARIODESTINATARIO, _TIPOAGENTE, _ESTRUTURAENTIDADE, _ACAOESGATILHODISPONIVEIS, _ENTIDADESDISPONIVEIS, _ESTRATEGIA, _TIPONOTIFICACAONATIVA;

	public static final String id = "id";
	public static final String tipoentidade = "tipoEntidade";
	public static final String nome = "nome";
	public static final String assunto = "assunto";
	public static final String conteudohtml = "conteudoHTML";
	public static final String acaogatilhonotificacao = "acaoGatilhoNotificacao";
	public static final String nomefabricagatilhonoticao = "nomeFabricaGatilhoNoticao";
	public static final String acaoautoexecucaoenvio = "acaoAutoExecucaoEnvio";
	public static final String nomefabricagatilhoacaoenviada = "nomeFabricaGatilhoAcaoEnviada";
	public static final String acaoautoexecucaoentrega = "acaoAutoExecucaoEntrega";
	public static final String nomefabricagatilhoacaoentrega = "nomeFabricaGatilhoAcaoEntrega";
	public static final String acaoautoexecucaoleitura = "acaoAutoExecucaoLeitura";
	public static final String nomefabricagatilhoacaoleitura = "nomeFabricaGatilhoAcaoLeitura";
	public static final String exigirrecibodeentrega = "exigirReciboDeEntrega";
	public static final String exigirreciboleitura = "exigirReciboLeitura";
	public static final String notificacaounica = "notificacaoUnica";
	public static final String notifificarviamatrix = "notifificarViaMatrix";
	public static final String notificarviamenu = "notificarViaMenu";
	public static final String notificarviateladebloqueio = "notificarViaTelaDeBLoqueio";
	public static final String notificarviamobile = "notificarViaMobile";
	public static final String notificarviawhatsapp = "notificarViaWhatsapp";
	public static final String notificarviaapipersonalizada = "notificarViaApiPersonalizada";
	public static final String notificarviasms = "notificarViaSMS";
	public static final String notificarviaemail = "notificarViaEmail";
	public static final String remetenteaguardaresposta = "remetenteAguardaResposta";
	public static final String minutosrenotificacao = "minutosRenotificacao";
	public static final String diaslog = "diasLog";
	public static final String ativo = "ativo";
	public static final String nomeentidadereferencia = "nomeEntidadeReferencia";
	public static final String caminhousuariodestinatario = "caminhoUsuarioDestinatario";
	public static final String tipoagente = "tipoAgente";
	public static final String estruturaentidade = "estruturaEntidade";
	public static final String acaoesgatilhodisponiveis = "acaoesGatilhoDisponiveis";
	public static final String entidadesdisponiveis = "entidadesDisponiveis";
	public static final String estrategia = "estrategia";
	public static final String tiponotificacaonativa = "tipoNotificacaoNativa";
}