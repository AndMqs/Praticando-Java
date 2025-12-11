package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;

public class DescontoProgressivo implements DescontoStrategy{

    private static final Logger LOGGER = LoggerFactory.getLogger(DescontoProgressivo.class);

    private final double limiteMedio;
    private final double limiteAlto;
    private final double descontoMedio;
    private final double descontoAlto;
    private final LocalDate dataExpiracao;

    public DescontoProgressivo(double limiteMedio, double limiteAlto,
                               double descontoMedio, double descontoAlto,
                               LocalDate dataExpiracao) {
        this.limiteMedio = limiteMedio;
        this.limiteAlto = limiteAlto;
        this.descontoMedio = descontoMedio;
        this.descontoAlto = descontoAlto;
        this.dataExpiracao = dataExpiracao;
    }

    @Override
    public double aplicarDesconto(double valor) {
        if (LocalDate.now().isAfter(dataExpiracao)) {
            LOGGER.warn("Promoção expirada! Data: {}, Hoje: {}",
                    dataExpiracao, LocalDate.now());
            return valor;
        }

        if (valor > limiteAlto) {
            double descontoAplicado = valor * descontoAlto;
            LOGGER.info("Desconto de {}% aplicado. Economia: R${}",
                    descontoAlto * 100, descontoAplicado);
            return valor - descontoAplicado;

        } else if (valor > limiteMedio) {
            double descontoAplicado = valor * descontoMedio;
            LOGGER.info("Desconto de {}% aplicado. Economia: R${}",
                    descontoMedio * 100, descontoAplicado);
            return valor - descontoAplicado;
        }
        return valor;
    }
}
