package GUI;

import Entidade.Cliente;
import Entidade.Produto;
import Servico.ComprarProduto;
import Servico.ExibirHistoricoCompras;
import Servico.VizualizarProduto;
import Tratamento.Limpeza;
import Tratamento.tratamento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Scanner;


public class MenuCliente {

  public static void menuCliente(Cliente cliente1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    Limpeza.limpeza();
    System.out.println("===HEALTH PHARMACY===\n");
    Thread.sleep(1500);
    System.out.println("Bem vindo ao menu do Cliente, " + cliente1.getNome() +"!");

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();

    try {
      // Recomendações do dia
      List<Produto> recomendacoes = em.createQuery("SELECT p FROM Produto p ORDER BY RAND()", Produto.class).setMaxResults(3).getResultList();
      System.out.println("\nRecomendações do dia: (Com base no seu histórico)");
      for (Produto produto : recomendacoes) {
        System.out.println(produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco()));
      }

      // 3 Produtos com os melhores preços
      TypedQuery<Produto> queryMelhoresPrecos = em.createQuery(
              "SELECT p FROM Produto p ORDER BY p.preco ASC", Produto.class
      ).setMaxResults(3);
      List<Produto> melhoresPrecos = queryMelhoresPrecos.getResultList();

      System.out.println("\nProdutos com os melhores preços:");
      for (Produto produto : melhoresPrecos) {
        System.out.println(produto.getNome() + " - R$ " + String.format("%.2f", produto.getPreco()));
      }
    } catch (Exception e) {
      System.out.println("\nErro ao buscar produtos: " + e.getMessage());
    } finally {
      em.close();
      emf.close();
    }

  System.out.println("\nDigite a opcao desejada:");
    System.out.println("[1] Comprar produtos");
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
