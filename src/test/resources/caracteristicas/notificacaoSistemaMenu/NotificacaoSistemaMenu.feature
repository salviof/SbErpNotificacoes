# language: pt
@NotificacaoSistemaMenu
Funcionalidade: Gerenciar notificações do sistema

Contexto: Usuário autenticado no sistema

Cenario: Usuário recebe uma notificação e confirma sua leitura
Dado que um usuário está logado no sistema
Quando o sistema registra uma nova notificação para o usuário logado
Então a notificação deve aparecer como não lida
E deve ser exibida na lista de notificações pendentes
Quando o usuário marca a notificação como lida
Então o status da notificação deve ser atualizado para lida
E a notificação não deve mais aparecer na lista de notificações pendentes