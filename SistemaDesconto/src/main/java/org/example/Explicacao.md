Sistema de Descontos em Loja Online

📝 Contexto:
Uma loja online precisa implementar diferentes estratégias de cálculo de desconto para promoções especiais. Atualmente, eles aplicam descontos de forma fixa, mas querem flexibilidade para criar novas campanhas promocionais.

🎯 Objetivo:
Implementar o padrão Strategy para calcular descontos de forma flexível.

🔧 Requisitos:

1. Interface DescontoStrategy:
  
   public interface DescontoStrategy {
   double aplicarDesconto(double valorOriginal);
   }
   </br>
2. Implemente as estratégias:

- DescontoFixo: Desconto de valor fixo (ex: R$10,00)
  </br>
    Ex: R$100 → R$90 (R$100 - R$10)

- DescontoPercentual: Desconto percentual (ex: 20%)
  </br>
    Ex: R$100 → R$80 (R$100 - 20%)

- DescontoProgressivo: Desconto que aumenta conforme o valor
  </br>
    Ex: Acima de R$200: 10%, acima de R$500: 15%

3. Classe CarrinhoCompras:
   - Atributo: DescontoStrategy estrategiaDesconto

    - Método: double calcularTotal(List<Item> itens)

* Soma valores dos itens

* Aplica a estratégia de desconto atual

* Retorna valor final

4. Classe Item:</br>
   Atributos: String nome, double preco;

💡 Dicas: 
</br>

    * Pense em como adicionar DescontoCupom sem modificar código existente

    * Como testar que cada estratégia calcula corretamente?

    * E se quiser combinar duas estratégias?