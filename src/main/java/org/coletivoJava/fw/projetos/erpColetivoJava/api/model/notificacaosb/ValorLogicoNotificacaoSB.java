package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.notificacaosb.ValoresLogicosNotificacaoSB;
import br.org.coletivojava.erp.notificacao.padrao.model.notificacao.NotificacaoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = NotificacaoSB.class)
public @interface ValorLogicoNotificacaoSB {

	ValoresLogicosNotificacaoSB calculo();
}