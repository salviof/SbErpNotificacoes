# language: pt
@NotificacaoSistemaBloqueio
Funcionalidade: Gerenciar notificações do sistema

Contexto: Usuário autenticado no sistema

Cenario: Usuário recebe uma notificação de bloqueio de tela e confirma sua leitura
Dado que um usuário está logado no sistema
Quando o sistema registra uma nova notificação de bloqueio p o usuário logado
Então a notificação deve aparecer na lista de mensagem de bloqueio
Quando o usuário marca a notificação como lida
Então o status da notificação deve ser atualizado para lida
E a notificação não deve mais aparecer na lista de notificações de bloqueio