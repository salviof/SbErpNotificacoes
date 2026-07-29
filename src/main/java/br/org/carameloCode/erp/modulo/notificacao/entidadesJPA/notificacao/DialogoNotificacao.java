/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulosSB.Persistencia.dao.UtilSBPersistencia;
import com.super_bits.modulosSB.Persistencia.registro.persistidos.EntidadeSimplesORM;
import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
import com.super_bits.modulosSB.SBCore.UtilGeral.MapaAcoesSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ComoAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.ComunicacaoTransient;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabStatusComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabTipoComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.ItensGenericos.basico.UsuarioAplicacaoEmExecucao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoSB;
import com.super_bits.modulosSB.SBCore.modulos.objetos.MapaObjetosProjetoAtual;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.EntidadeSimples;

/**
 *
 * @author salvio
 */
@InfoObjetoSB(tags = "Dialogo notificaçao", plural = "Dialogos de notificações")
public class DialogoNotificacao extends ComunicacaoTransient {

    public DialogoNotificacao(NotificacaoSB pNotificacao) {

        super(new UsuarioAplicacaoEmExecucao(), pNotificacao.getUsuario(),
                pNotificacao.getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada() == null
                ? FabTipoComunicacao.NOTIFICAR.getRegistro()
                : FabTipoComunicacao.PERSONALIZADA.getRegistro()
        );

        setUmaComunicacaoPersonalizada(pNotificacao.getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada() != null);
        String url;

        if (isUmaComunicacaoPersonalizada()) {
            ComoAcaoDoSistema acao = MapaAcoesSistema.getAcaoDoSistemaByNomeUnico(pNotificacao.getTipoNotificacao().getNomeFabricaAcaoRespostaPersonalizada());
            if (pNotificacao.getTipoNotificacao().getNomeEntidadeReferencia() != null) {
                EntidadeSimplesORM entidade = (EntidadeSimplesORM) UtilSBPersistencia.getRegistroByID(MapaObjetosProjetoAtual.getClasseDoObjetoByNome(pNotificacao.getTipoNotificacao().getNomeEntidadeReferencia()), Long.valueOf(pNotificacao.getCodigoEntidadeRelacionada()));
                url = CarameloCode.getServicoVisualizacao().getEndrRemotoFormulario(acao.getEnumAcaoDoSistema(), entidade);
            } else {
                url = CarameloCode.getServicoVisualizacao().getEndrRemotoFormulario(acao.getEnumAcaoDoSistema());
            }
            setUrlRespostaPersonalizada(url);
        }

        setAssunto(pNotificacao.getAssunto());
        setMensagem(pNotificacao.getConteudoHtml());
        switch (pNotificacao.getStatus().getStatusEnum()) {
            case RASCUNHO:
                // setStatusComunicacao(FabStatusComunicacao.SELADO);
                break;
            case REGISTRADA:
            case ENVIADA:
            case ENTREGUE:
                setStatusComunicacao(FabStatusComunicacao.ENVIADO);
                break;
            case LIDA:
            case ENCERRADA_SEM_CONFIRMACAO:
                setStatusComunicacao(FabStatusComunicacao.RESPONDIDO);
                break;
            default:
                throw new AssertionError(pNotificacao.getStatus().getStatusEnum().name());

        }

    }

    @Override
    public void setCodigoSelo(String codigoSelo) {
        super.setCodigoSelo(codigoSelo); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
