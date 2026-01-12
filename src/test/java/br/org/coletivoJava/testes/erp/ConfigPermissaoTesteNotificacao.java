/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivoJava.testes.erp;

import br.org.coletivojava.erp.notificacao.padrao.controller.ModuloNotificacao;
import com.super_bits.modulos.SBAcessosModel.ConfigPermissoesAcessoModelAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.permissoes.ErroDadosDeContatoUsuarioNaoEncontrado;
import com.super_bits.modulosSB.SBCore.modulos.erp.FabTipoAgenteOrganizacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoGrupoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.basico.ComoUsuario;
import com.super_bits.modulosSB.SBCore.modulos.objetos.entidade.contato.ComoContatoHumano;
import com.super_bits.modulosSB.SBCore.modulos.view.menu.ComoMenusDeSessao;
import org.coletivojava.fw.api.objetoNativo.view.menu.MenusDaSessao;
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
    public ComoMenusDeSessao definirMenu(ComoGrupoUsuario pGrupo) {
        return new MenusDaSessao(new MenuSBFW(), new MenuSBFW());
    }

    @Override
    public FabTipoAgenteOrganizacao getTipoAgente(ComoUsuario pUsuario) {
        return FabTipoAgenteOrganizacao.ATENDIMENTO;
    }

    @Override
    public ComoContatoHumano getContatoDoUsuario(ComoUsuario pUsuairo) throws ErroDadosDeContatoUsuarioNaoEncontrado {
        return null;
    }

}
