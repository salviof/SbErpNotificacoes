package br.org.coletivoJava.fw.erp.implementacao.transportecomunicacao;

import com.super_bits.modulosSB.SBCore.modulos.erp.ItfServicoLinkDeEntidadesERP;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetMenuPadrao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.erp.repositorioLinkEntidades.RepositorioLinkEntidadesGenerico;
import br.org.coletivoJava.fw.api.erp.transportecomunicacao.MsgDisparoIntranetMenu;

@MsgDisparoIntranetMenu
public class MsgDisparoIntranetMenuimpl
		extends
			RepositorioLinkEntidadesGenerico
		implements
			com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDisparoComunicacao {

	@Override
	public void dispararRespostaComunicacao(ItfDialogo itfDialogo) {
	}

	@Override
	public boolean validarDadosDisparo(
			com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo itfDialogo) {
		return false;
	}

	@Override
	public String dispararInicioComunicacao(
			com.super_bits.modulosSB.SBCore.modulos.comunicacao.ItfDialogo itfDialogo) {
		return null;
	}
}