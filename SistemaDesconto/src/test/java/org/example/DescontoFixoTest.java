package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescontoFixoTest {

    @Test
    @DisplayName("Deve aplicar desconto fixo corretamente")
    void testAplicarDescontoFixo() {
        DescontoStrategy desconto = new DescontoFixo(20.0);
        double valorOriginal = 100.0;
        double valorComDesconto = desconto.aplicarDesconto(valorOriginal);
        assertEquals(80.0, valorComDesconto, 0.001);
    }

}