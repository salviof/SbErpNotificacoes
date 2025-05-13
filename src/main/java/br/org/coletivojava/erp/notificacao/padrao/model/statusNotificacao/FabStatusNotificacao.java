/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao;

import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaStatusComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ItfAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.comunicacao.FabStatusComunicacao;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabStatusNotificacao implements ItfFabricaStatusComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 1l, nomeObjeto = "Rascunho")
    RASCUNHO,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 2l, nomeObjeto = "Registrado")
    REGISTRADA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 3l, nomeObjeto = "Registrado")
    ENVIADA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 4l, nomeObjeto = "Entregue")
    ENTREGUE,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 5l, nomeObjeto = "Lida")
    LIDA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 6l, nomeObjeto = "Encerrada sem confirmacao")
    ENCERRADA_SEM_CONFIRMACAO,;

    @Override
    public StatusNotificacao getRegistro() {
        StatusNotificacao status = (StatusNotificacao) ItfFabricaStatusComPersistencia.super.getRegistro();
        switch (this) {

            case REGISTRADA:
                status.setIcone("fa fa-archive");
                status.setCor("#1976D2");
                break;
            case ENTREGUE:
                status.setIcone("fa fa-envelope-o");
                status.setCor("#388E3C");
                break;
            case LIDA:
                status.setIcone("fa fa-envelope-open-o");
                status.setCor("#0288D1");
                break;
            case ENVIADA:
                status.setIcone("fa fa-paper-plane-o");
                status.setCor("#1E88E5");
                break;
            case ENCERRADA_SEM_CONFIRMACAO:
                status.setIcone("fa fa-chain-broken");
                status.setCor("#E53935");
                break;
            case RASCUNHO:
                status.setIcone("fa fa-pencil");
                status.setCor("#A0A0A0");
                break;
            default:
                throw new AssertionError();
        }
        return status;
    }

    @Override
    public List<ItfAcaoDoSistema> opcoesPorStatus() {
        return new ArrayList<>();
    }

    public FabStatusComunicacao statusCOmunicacao() {
        switch (this) {

            case REGISTRADA:
                return FabStatusComunicacao.SELADO;

            case ENVIADA:
                return FabStatusComunicacao.ENVIADO;

            case ENTREGUE:

                return FabStatusComunicacao.RECEBIDO;

            case LIDA:
                return FabStatusComunicacao.RESPONDIDO;
            case ENCERRADA_SEM_CONFIRMACAO:
                return FabStatusComunicacao.RECEBIDO;
            case RASCUNHO:
                return null;

            default:
                throw new AssertionError();
        }
    }
}
