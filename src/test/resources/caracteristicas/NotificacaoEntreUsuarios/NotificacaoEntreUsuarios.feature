# language: pt
@NotificacaoEntreUsuarios
Funcionalidade: Gerenciar notificações entre usuários

Cenario: Usuário recebe uma notificação e confirma sua leitura
Dado que o usuário remetente está logado no sistema
Quando o remetente registra uma nova notificação para o destinatário
Dado que o usuário destinatário acessa o sistema
Então a notificação deve aparecer no serviço de mensagens do destinatário
Quando o destinatário marca a notificação como lida
Então uma nova notificação de confirmação deve ser emitida para o remetente
Dado que o remetente realiza novo acesso ao sistema
Então o remetente visualiza a confirmação de leitura do destinatário