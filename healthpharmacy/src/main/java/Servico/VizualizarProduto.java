package Servico;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Entidade.Produto;

public class VizualizarProduto {
  public static void visualizarProdutosDisponiveis() {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    TypedQuery<Produto> query = em.createQuery("SELECT p FROM Produto p", Produto.class);
    List<Produto> produtos = query.getResultList();

    if (produtos.isEmpty()) {
      System.out.println("\nNao ha produtos disponiveis no momento.");
    } else {
      System.out.println("Produtos Disponiveis:\n");
      for (Produto produto : produtos) {
        System.out.println(produto);
      }
    }

    em.close();
    emf.close();
    Scanner sc = new Scanner(System.in);
    System.out.print("\nPressione Enter para voltar ao menu anterior.");
    sc.nextLine();
  }
}
