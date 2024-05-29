package GUI;

import Entidade.Cliente;
import Tratamento.tratamento;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MenuCliente {

  public static void menuCliente(Cliente cliente1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);

    System.out.println("Menu do Cliente\n\n");
    Thread.sleep(1500);
    System.out.println("[1] Comprar produto");
    System.out.println("[2] Vizualizar produtos disponíveis");
    System.out.println("[3] Historico de Compras");
    System.out.println("[4] Informações do cliente");
    System.out.println("[5] Carrinho de Compras");
    System.out.println("[6] Retornar ao menu de login");
    System.out.println("[7] Sair do aplicativo");

    System.out.print("--> ");
    String escolha = sc.nextLine();
    switch (escolha) {
      case "1":
        break;
      case "2":
        break;
      case "3":
        break;
      case "4":
        break;
      case "5":
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        MenuCarrinho.menuCarrinho(cliente1, em);
        em.close();
        emf.close();
        break;
      case "6":
        MenuEntrada.menu();
        break;
      case "7":
        System.exit(0);
        break;
      default:
        tratamento.opcaoInvalida();
        menuCliente(cliente1);
        break;
    }
  }
}
