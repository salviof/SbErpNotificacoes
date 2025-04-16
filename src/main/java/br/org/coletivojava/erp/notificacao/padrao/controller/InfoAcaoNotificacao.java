/*
 *  Desenvolvido pela equipe Super-Bits.com CNPJ 20.019.971/0001-90

 */
package br.org.coletivojava.erp.notificacao.padrao.controller;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 *
 * Esta anotação faz parate do conjutnos de soluções da camada controller do
 * sistema
 *
 * Deve ser utilizado para nomear as fabricas de ações do sistema
 *
 * @author <a href="mailto:salviof@gmail.com">Salvio Furbino</a>
 * @since 16/12/2015
 * @version 1.0
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InfoAcaoNotificacao {

    public FabAcaoNotificacaoPadraoSB acao();

}
