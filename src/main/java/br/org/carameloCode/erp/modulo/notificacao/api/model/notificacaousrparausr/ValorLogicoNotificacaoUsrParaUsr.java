package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaousrparausr.ValoresLogicosNotificacaoUsrParaUsr;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoUsrParaUsr;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = NotificacaoUsrParaUsr.class)
public @interface ValorLogicoNotificacaoUsrParaUsr {

	ValoresLogicosNotificacaoUsrParaUsr calculo();
}