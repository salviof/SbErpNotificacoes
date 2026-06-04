package org.coletivoJava.fw.projetos.erpColetivoJava.api.cucumber.notificacaosistemabloqueio;
public enum EtapasNotificacaoSistemaBloqueio {
	_DADO_QUE_UM_USUARIO_ESTA_LOGADO_NO_SISTEMA, _QUANDO_O_SISTEMA_REGISTRA_UMA_NOVA_NOTIFICACAO_DE_BLOQUEIO_P_O_USUARIO_LOGADO, _ENTAO_A_NOTIFICACAO_DEVE_APARECER_NA_LISTA_DE_MENSAGEM_DE_BLOQUEIO, _QUANDO_O_USUARIO_MARCA_A_NOTIFICACAO_COMO_LIDA, _ENTAO_O_STATUS_DA_NOTIFICACAO_DEVE_SER_ATUALIZADO_PARA_LIDA, _E_A_NOTIFICACAO_NAO_DEVE_MAIS_APARECER_NA_LISTA_DE_NOTIFICACOES_DE_BLOQUEIO;

	public static final String DADO_QUE_UM_USUARIO_ESTA_LOGADO_NO_SISTEMA = "que um usuário está logado no sistema";
	public static final String QUANDO_O_SISTEMA_REGISTRA_UMA_NOVA_NOTIFICACAO_DE_BLOQUEIO_P_O_USUARIO_LOGADO = "o sistema registra uma nova notificação de bloqueio p o usuário logado";
	public static final String ENTAO_A_NOTIFICACAO_DEVE_APARECER_NA_LISTA_DE_MENSAGEM_DE_BLOQUEIO = "a notificação deve aparecer na lista de mensagem de bloqueio";
	public static final String QUANDO_O_USUARIO_MARCA_A_NOTIFICACAO_COMO_LIDA = "o usuário marca a notificação como lida";
	public static final String ENTAO_O_STATUS_DA_NOTIFICACAO_DEVE_SER_ATUALIZADO_PARA_LIDA = "o status da notificação deve ser atualizado para lida";
	public static final String E_A_NOTIFICACAO_NAO_DEVE_MAIS_APARECER_NA_LISTA_DE_NOTIFICACOES_DE_BLOQUEIO = "a notificação não deve mais aparecer na lista de notificações de bloqueio";
}