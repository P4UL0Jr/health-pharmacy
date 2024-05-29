package Servico;

import java.util.Scanner;
import Entidade.Carrinho;
import Entidade.Produto;

public class VizualizarCarrinho {
  public static void visualizarCarrinho(Carrinho carrinho) {
    Scanner sc = new Scanner(System.in);
    if (carrinho.getProdutos().isEmpty()) {
      System.out.println("Seu carrinho está vazio.");
    } else {
      System.out.println("\nItens no seu carrinho:");
      double valorTotal = 0.0;

      for (Produto produto : carrinho.getProdutos()) {
        System.out.println(produto);
        valorTotal += produto.getPreco();
      }

      System.out.printf("\nValor total do carrinho: R$ %.2f\n", valorTotal);
    }
    System.out.println("Pressione enter para retornar ao menu de administração.");
    sc.nextLine();
  }
}
