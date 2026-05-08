/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao.NotificacaoSB;
import br.org.coletivoJava.testes.erp.ConfigCoreApiNotificacaoSBTestes;
import br.org.coletivoJava.testes.erp.ConfigPersistenciaTestesNotificacao;
import com.super_bits.modulosSB.Persistencia.ConfigGeral.SBPersistencia;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.modulos.geradorCodigo.model.EstruturaDeEntidade;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import org.junit.Test;
import testesFW.TesteJunitJPAModuloERP;

/**
 *
 * @author salvio
 */
public class TesteConformidade extends TesteJunitJPAModuloERP {

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreApiNotificacaoSBTestes(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        SBPersistencia.configuraJPA(new ConfigPersistenciaTestesNotificacao(), true, true);

    }

    @Test
    public void teste() {
        EstruturaDeEntidade esttrutura = MapaObjetosProjetoAtual.getEstruturaObjeto(NotificacaoSB.class, true);
        if (esttrutura.isUmaEntidadeModuloERP()) {
            System.out.println("teste");
        }
        gerarCodigoModelProjeto();

    }
}
