package org.example;

public class DescontoPercentual implements DescontoStrategy {

    private double percentualDesconto;

    public DescontoPercentual(double percentualDesconto) {
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public double aplicarDesconto(double valorOriginal) {
        return valorOriginal - (valorOriginal * percentualDesconto / 100);
    }
}
