package Servico;

import java.util.Scanner;

public class RemoverProduto {
  public static void removerProduto() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Remoção de produto\n");
    System.out.println("Digite o ID do produto que deseja remover: \n");
    System.out.print("--> ");
    String id = sc.nextLine();
    
  }
}