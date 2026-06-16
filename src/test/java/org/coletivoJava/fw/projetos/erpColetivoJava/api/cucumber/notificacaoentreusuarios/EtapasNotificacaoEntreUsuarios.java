package org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaoentreusuarios;
public enum EtapasNotificacaoEntreUsuarios {
	_DADO_QUE_O_USUARIO_REMETENTE_ESTA_LOGADO_NO_SISTEMA, _QUANDO_O_REMETENTE_REGISTRA_UMA_NOVA_NOTIFICACAO_PARA_O_DESTINATARIO, _DADO_QUE_O_USUARIO_DESTINATARIO_ACESSA_O_SISTEMA, _ENTAO_A_NOTIFICACAO_DEVE_APARECER_NO_SERVICO_DE_MENSAGENS_DO_DESTINATARIO, _QUANDO_O_DESTINATARIO_MARCA_A_NOTIFICACAO_COMO_LIDA, _ENTAO_UMA_NOVA_NOTIFICACAO_DE_CONFIRMACAO_DEVE_SER_EMITIDA_PARA_O_REMETENTE, _DADO_QUE_O_REMETENTE_REALIZA_NOVO_ACESSO_AO_SISTEMA, _ENTAO_O_REMETENTE_VISUALIZA_A_CONFIRMACAO_DE_LEITURA_DO_DESTINATARIO;

	public static final String DADO_QUE_O_USUARIO_REMETENTE_ESTA_LOGADO_NO_SISTEMA = "que o usuário remetente está logado no sistema";
	public static final String QUANDO_O_REMETENTE_REGISTRA_UMA_NOVA_NOTIFICACAO_PARA_O_DESTINATARIO = "o remetente registra uma nova notificação para o destinatário";
	public static final String DADO_QUE_O_USUARIO_DESTINATARIO_ACESSA_O_SISTEMA = "que o usuário destinatário acessa o sistema";
	public static final String ENTAO_A_NOTIFICACAO_DEVE_APARECER_NO_SERVICO_DE_MENSAGENS_DO_DESTINATARIO = "a notificação deve aparecer no serviço de mensagens do destinatário";
	public static final String QUANDO_O_DESTINATARIO_MARCA_A_NOTIFICACAO_COMO_LIDA = "o destinatário marca a notificação como lida";
	public static final String ENTAO_UMA_NOVA_NOTIFICACAO_DE_CONFIRMACAO_DEVE_SER_EMITIDA_PARA_O_REMETENTE = "uma nova notificação de confirmação deve ser emitida para o remetente";
	public static final String DADO_QUE_O_REMETENTE_REALIZA_NOVO_ACESSO_AO_SISTEMA = "que o remetente realiza novo acesso ao sistema";
	public static final String ENTAO_O_REMETENTE_VISUALIZA_A_CONFIRMACAO_DE_LEITURA_DO_DESTINATARIO = "o remetente visualiza a confirmação de leitura do destinatário";
}