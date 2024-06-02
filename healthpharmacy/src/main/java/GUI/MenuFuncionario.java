package GUI;

import java.util.Scanner;
import Entidade.Funcionario;
import Tratamento.Limpeza;
import Tratamento.tratamento;

public class MenuFuncionario {

  public static void menuFuncionario(Funcionario funcionario) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Limpeza.limpeza();
    System.out.println("Menu do Funcionário\n\n");
    Thread.sleep(1500);
    System.out.println("[1] Gereneciar produtos");
    System.out.println("[2] Informações do funcionários");
    System.out.println("[3] Retornar ao menu de login");
    System.out.println("[4] Sair do aplicativo\n");

    System.out.print("--> ");
    String escolha = sc.nextLine();
    Limpeza.limpeza();
    switch (escolha) {
      case "1":
        MenuProdutos.menuProdutos(funcionario);
        break;
      case "2":
        System.out.println(funcionario);
        System.out.println("\nPressione Enter para retornar");
        sc.nextLine();
        menuFuncionario(funcionario);
        break;
      case "3":
        MenuEntrada.menu();
        break;
      case "4":
        System.out.println("Obrigado pela confianca, volte sempre!");
        Thread.sleep(2000);
        sc.close();
        System.exit(0);
        break;
      default:
        sc.nextLine();
        System.out.println();
        tratamento.opcaoInvalida();
        menuFuncionario(funcionario);
        break;
    }
  }
}