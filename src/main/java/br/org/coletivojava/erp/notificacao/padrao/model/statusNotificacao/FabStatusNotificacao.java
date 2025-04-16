/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package br.org.coletivojava.erp.notificacao.padrao.model.statusNotificacao;

import com.super_bits.modulosSB.Persistencia.fabrica.ItfFabricaStatusComPersistencia;
import com.super_bits.modulosSB.SBCore.modulos.Controller.Interfaces.acoes.ItfAcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.objetos.InfoCampos.anotacoes.InfoObjetoDaFabrica;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author salvio
 */
public enum FabStatusNotificacao implements ItfFabricaStatusComPersistencia {

    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 1l, nomeObjeto = "Registrado")
    REGISTRADA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 1l, nomeObjeto = "Registrado")
    ENVIADA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 2l, nomeObjeto = "Entregue")
    ENTREGUE,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 3l, nomeObjeto = "Lida")
    LIDA,
    @InfoObjetoDaFabrica(classeObjeto = StatusNotificacao.class, id = 3l, nomeObjeto = "Encerrada sem confirmacao")
    ENCERRADA_SEM_CONFIRMACAO,;

    @Override
    public StatusNotificacao getRegistro() {
        StatusNotificacao status = (StatusNotificacao) ItfFabricaStatusComPersistencia.super.getRegistro();
        switch (this) {

            case REGISTRADA:
                status.setIcone("fa fa-hand-paper-o");
                break;
            case ENTREGUE:
                status.setIcone("fa fa-envelope-o");
                break;
            case LIDA:
                status.setIcone("fa fa-envelope-open-o");
                break;
            case ENVIADA:
                status.setIcone("fa fa-paper-plane-o");
                break;
            case ENCERRADA_SEM_CONFIRMACAO:
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

}
