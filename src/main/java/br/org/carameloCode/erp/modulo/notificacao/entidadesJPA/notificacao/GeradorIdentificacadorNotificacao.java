package br.org.carameloCode.erp.modulo.notificacao.entidadesJPA.notificacao;

import com.super_bits.modulosSB.SBCore.ConfigGeral.CarameloCode;
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
            // & Long.MAX_VALUE torna o valor sempre positivo da maneira mais eficiente possível
            //* O operador {& Long.MAX_VALUE} é usado para **zerar o bit de sinal**
            //* (bit 63) do valor retornado por {@code getMostSignificantBits()}.
            //* Isso garante que o número sempre seja positivo, mesmo quando o bit mais a esquerda estiver ligado (o que tornaria o long negativo).

            return UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;

        } catch (Throwable t) {
            throw new HibernateException("Erro determinando id para notificacao " + pObj + t.getMessage());

        }

    }
}
