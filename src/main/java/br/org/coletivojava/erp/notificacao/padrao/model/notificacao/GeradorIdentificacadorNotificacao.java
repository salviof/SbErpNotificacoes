package br.org.coletivojava.erp.notificacao.padrao.model.notificacao;

import com.super_bits.modulos.SBAcessosModel.model.acoes.AcaoDoSistema;
import com.super_bits.modulosSB.SBCore.modulos.Controller.UtilSBController;
import java.io.Serializable;
import java.util.UUID;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

/**
 *
 * @author salvio
 */
public class GeradorIdentificacadorNotificacao implements IdentifierGenerator {

    @Override
    public Serializable generate(SharedSessionContractImplementor ssci, Object pObj) throws HibernateException {
        try {
            NotificacaoSB notificacao = ((NotificacaoSB) pObj);

            return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        } catch (Throwable t) {
            throw new HibernateException("Erro determinando id para notificacao " + pObj + t.getMessage());

        }

    }
}
