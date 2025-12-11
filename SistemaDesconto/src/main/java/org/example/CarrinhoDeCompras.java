package org.example;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> itens;
    private DescontoStrategy descontoStrategy;

    public CarrinhoDeCompras() {
        this.itens = new ArrayList<>();
    }

    public void setDescontoStrategy(DescontoStrategy descontoStrategy) {
        this.descontoStrategy = descontoStrategy;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void deletarItem(Item item) {
        itens.remove(item);
    }

    public double calcularTotal(){
        double subtotal = 0;

        for (Item item : this.itens) {
            subtotal += item.getPreco();
        }

        if(descontoStrategy != null){
            return descontoStrategy.aplicarDesconto(subtotal);
        }
        return subtotal;
    }
}
