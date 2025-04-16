/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.controller.ModuloNotificacao;
import com.super_bits.modulos.SBAcessosModel.ConfigPermissoesAcessoModelAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfGrupoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ItfMenusDeSessao;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.MenusDaSessao;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenuSBFW;

/**
 *
 * @author salvio
 */
public class ConfigPermissaoTesteNotificacao extends ConfigPermissoesAcessoModelAbstrato {

    public ConfigPermissaoTesteNotificacao(Class[] pClassesControllers) {
        super(new Class[]{ModuloNotificacao.class});
    }

    @Override
    public ItfMenusDeSessao definirMenu(ItfGrupoUsuario pGrupo) {
        return new MenusDaSessao(new MenuSBFW(), new MenuSBFW());
    }

}
