package GUI;

import java.util.Scanner;

import Entidade.Funcionario;
import Tratamento.tratamento;

public class MenuFuncionario {

  public static void menuFuncionario(Funcionario funcionario1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    sc.reset();
    System.out.println();
    System.out.println("Menu do Funcionário\n\n");
    Thread.sleep(1500);
    System.out.println("[1] Gereneciar produtos");
    System.out.println("[2] Informações do funcionários");
    System.out.println("[3] Retornar ao menu de login");
    System.out.println("[4] Sair do aplicativo");

    try {

      System.out.print("--> ");
      String escolha = sc.nextLine();
      switch (escolha) {
        case "1":
          MenuProdutos.menuProdutos(funcionario1);
          break;
        case "2":
          System.out.println(funcionario1);
          System.out.println("\nPressione Enter para retornar");
          sc.nextLine();
          menuFuncionario(funcionario1);
          break;
        case "3":
          MenuEntrada.menu();
          break;
        case "4":
          System.exit(0);
          break;
        default:
          sc.nextLine();
          System.out.println();
          tratamento.opcaoInvalida();
          menuFuncionario(funcionario1);
          break;
      }
    } catch (Exception e) {
      sc.nextLine();
      System.out.println();
      tratamento.valorInvalido();
      menuFuncionario(funcionario1);
    }
  }
}