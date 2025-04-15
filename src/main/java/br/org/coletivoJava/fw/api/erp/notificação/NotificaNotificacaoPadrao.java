package br.org.coletivoJava.fw.api.erp.notificação;

import javax.inject.Qualifier;
import br.org.coletivojava.erp.notificacao.api.ItfERPNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.erp.InfoReferenciaApiErp;
import br.org.coletivojava.erp.notificacao.api.ERPNotificacoes;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Qualifier
@InfoReferenciaApiErp(tipoObjeto = ERPNotificacoes.class)
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface NotificaNotificacaoPadrao {
}