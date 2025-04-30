package org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import org.coletivoJava.fw.projetos.erpColetivoJava.api.model.tiponotificacao.ValoresLogicosTipoNotificacao;
import br.org.coletivojava.erp.notificacao.padrao.model.tipoNotificacao.TipoNotificacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoReferenciaEntidade;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@InfoReferenciaEntidade(tipoObjeto = TipoNotificacao.class)
public @interface ValorLogicoTipoNotificacao {

	ValoresLogicosTipoNotificacao calculo();
}