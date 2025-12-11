package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GincanaTest {
    
    @Test
    void testExemploBasico1() {
        String[] entrada = {"as", "mas", "amor", "amoreco"};
        String[] esperado = {"as", "amor"};
        assertArrayEquals(esperado, Gincana.substringStr(entrada));
    }

    @Test
    void testExemploBasico2() {
        String[] entrada = {"carro", "ca", "paz", "pá"};
        String[] esperado = {"ca"};
        assertArrayEquals(esperado, Gincana.substringStr(entrada));
    }

    @Test
    void testExemploBasico3() {
        String[] entrada = {"sol", "lua", "mar"};
        String[] esperado = {};
        assertArrayEquals(esperado, Gincana.substringStr(entrada));
    }

}