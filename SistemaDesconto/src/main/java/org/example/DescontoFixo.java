package org.example;

public class DescontoFixo implements DescontoStrategy{

    private double valorDesconto;

    public DescontoFixo(double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - valorDesconto;
    }
}
