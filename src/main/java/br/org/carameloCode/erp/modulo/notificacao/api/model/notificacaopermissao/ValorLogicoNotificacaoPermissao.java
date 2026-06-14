package br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaopermissao;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import br.org.carameloCode.erp.modulo.notificacao.api.model.notificacaopermissao.ValoresLogicosNotificacaoPermissao;
import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoPermissao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = NotificacaoPermissao.class)
public @interface ValorLogicoNotificacaoPermissao {

	ValoresLogicosNotificacaoPermissao calculo();
}