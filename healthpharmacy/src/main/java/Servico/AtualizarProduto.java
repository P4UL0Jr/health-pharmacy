package Servico;

import java.util.Scanner;


public class AtualizarProduto {
  
  public static void atualizarProduto() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Atualização de produto:\n");
    System.out.println("Digite o ID do produto que deseja atualizar: ");

    System.out.print("--> ");
    String id = sc.nextLine();

  }
}