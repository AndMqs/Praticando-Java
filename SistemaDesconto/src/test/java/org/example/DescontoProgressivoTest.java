package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DescontoProgressivoTest {

    @Test
    @DisplayName("Deve aplicar 25% de desconto quando valor > 500 e promoção válida")
    void deveAplicarDescontoAlto_QuandoValorAcimaLimiteAlto() {
        // ===== ARRANGE (Preparação) =====
        // Cria promoção que expira AMANHÃ (ainda válida)
        LocalDate dataExpiracao = LocalDate.now().plusDays(1);
        DescontoStrategy desconto = new DescontoProgressivo(
                200.0,   // limite médio
                500.0,   // limite alto
                0.10,    // 10% desconto médio
                0.25,    // 25% desconto alto
                dataExpiracao
        );

        double valorCompra = 600.0; // Acima de 500 → 25% desconto

        // ===== ACT (Execução) =====
        double valorFinal = desconto.aplicarDesconto(valorCompra);

        // ===== ASSERT (Verificação) =====
        // Cálculo esperado: 600 - 25% = 450
        double valorEsperado = 450.0;

        // Compara com margem de erro de 0.001 (para números decimais)
        assertEquals(valorEsperado, valorFinal, 0.001,
                "600 com 25% de desconto deve resultar em 450");

        // Verificação extra:
        assertTrue(valorFinal < valorCompra,
                "Valor com desconto deve ser menor que original");
    }


    @Test
    @DisplayName("Deve aplicar 10% de desconto quando valor > 200 e")
    void testDescontoMedio_LimiteMedio(){

        // Arrange
        LocalDate dataNuncaExpira = LocalDate.now().plusYears(100);
        DescontoStrategy desconto = new DescontoProgressivo(
                200.0,   // limite médio
                500.0,   // limite alto
                0.10,    // 10% desconto médio
                0.25,    // 25% desconto alto
                dataNuncaExpira
        );

        double valorCompra = 300.0; // Acima de 200 → 10% desconto

        // Act
        double valorFinal = desconto.aplicarDesconto(valorCompra);

        // Assert
        double valorEsperado = 270.0; // 300 - 10% = 270
        assertEquals(valorEsperado, valorFinal, 0.001,
                "300 com 10% de desconto deve resultar em 270");


    }
}