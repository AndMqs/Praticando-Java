package org.example;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
        DescontoStrategy descontoFixo = new DescontoFixo(20.0);
        DescontoStrategy descontoPercentual = new DescontoPercentual(5.0);
        LocalDate inicioDescontoNatal = LocalDate.now();
        LocalDate fimDescontoNatal = inicioDescontoNatal.plusDays(20);
        DescontoStrategy descontoProgressivo = new DescontoProgressivo(200.0, 400.0, 0.05, 0.10,fimDescontoNatal);

        Item[] catalogo = {
                new Item("Camisa", 50.0),
                new Item("Calça", 150.0),
                new Item("Tênis", 200.0),
                new Item("Bermuda", 80.0),
                new Item("Jaqueta", 300.0)
        };

        carrinho.adicionarItem(catalogo[0]);
        carrinho.adicionarItem(catalogo[3]);
        carrinho.adicionarItem(catalogo[4]);

        System.out.println("Total sem desconto: " + carrinho.calcularTotal());

//        carrinho.setDescontoStrategy(descontoProgressivo);
//        System.out.println("Total com desconto progressivo: " + carrinho.calcularTotal());

//        carrinho.setDescontoStrategy(descontoPercentual);
//        System.out.println("Total com desconto percentual: " + carrinho.calcularTotal());

        carrinho.setDescontoStrategy(descontoFixo);
        System.out.println("Total com desconto fixo: " + carrinho.calcularTotal());

    }
}