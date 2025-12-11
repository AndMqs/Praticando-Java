package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescontoPercentualTest {

    @Test
    @DisplayName("Deve aplicar desconto percentual corretamente")
    void testAplicarDescontoPercentual() {
        DescontoStrategy desconto = new DescontoPercentual(15.0);
        double valorOriginal = 200.0;
        double valorComDesconto = desconto.aplicarDesconto(valorOriginal);
        assertEquals(170.0, valorComDesconto, 0.001);
    }
}