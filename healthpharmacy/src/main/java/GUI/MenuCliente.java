package GUI;

import Entidade.Cliente;
import Servico.ComprarProduto;
import Servico.ExibirHistoricoCompras;
import Servico.VizualizarProduto;
import Tratamento.Limpeza;
import Tratamento.tratamento;
import java.util.Scanner;


public class MenuCliente {

  public static void menuCliente(Cliente cliente1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Limpeza.limpeza();
    System.out.println("Menu do Cliente\n\n");
    Thread.sleep(1500);
    System.out.println("[1] Comprar produto");
    System.out.println("[2] Vizualizar produtos disponiveis");
    System.out.println("[3] Historico de Compras");
    System.out.println("[4] Informacoes do cliente");
    System.out.println("[5] Retornar ao menu de login");
    System.out.println("[6] Sair do aplicativo\n");

    System.out.print("--> ");
    String escolha = sc.nextLine();
    Limpeza.limpeza();
    switch (escolha) {
      case "1":
      ComprarProduto.comprarProduto(cliente1);
        menuCliente(cliente1);
        break;
      case "2":
        VizualizarProduto.visualizarProdutosDisponiveis();
        menuCliente(cliente1);
        break;
      case "3":
        ExibirHistoricoCompras.exibirHistoricoCompras(cliente1);
        menuCliente(cliente1);
        break;
      case "4":
        System.out.println("Informacoes do cliente\n");
        System.out.println(cliente1);
        System.out.println("\nPressione Enter para retornar");
        sc.nextLine();
        menuCliente(cliente1);
        break;
      case "5":
        MenuEntrada.menu();
        break;
      case "6":
        System.out.println("Obrigado pela confianca, volte sempre!");
        Thread.sleep(2000);
        sc.close();
        System.exit(0);
        break;
      default:
        tratamento.opcaoInvalida();
        menuCliente(cliente1);
        break;
    }
  }
}
