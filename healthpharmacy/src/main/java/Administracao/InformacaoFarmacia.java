package Administracao;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class InformacaoFarmacia {
  public static void informacaoFarmacia() throws InterruptedException {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();

    String cnpj = "12.345.678/0001-90";
    String razaoSocial = "Health Pharmacy Saude & Bem-Estar";
    String email = "healthPharmacy@hotmail.com";
    double totalProdutosVendidos;
    double lucroTotal;

    try {
      TypedQuery<Long> queryTotalProdutosVendidos = em.createQuery(
          "SELECT COALESCE(SUM(i.quantidade), 0) FROM PedidoFinalizado p JOIN p.itens i", Long.class);
      totalProdutosVendidos = queryTotalProdutosVendidos.getSingleResult();

      TypedQuery<Double> queryLucroTotal = em.createQuery("SELECT COALESCE(SUM((SELECT SUM(i.produto.preco * i.quantidade) FROM p.itens i)), 0) FROM PedidoFinalizado p",Double.class);
      lucroTotal = queryLucroTotal.getSingleResult();

      System.out.println("\nDados da Farmacia\n");
      System.out.println("Total de vendas: " + String.format("%.0f", totalProdutosVendidos));
      System.out.println("Lucro total: R$ " + String.format("%.2f", lucroTotal));
      System.out.println("\nCNPJ: " + cnpj);
      System.out.println("Razao Social: " + razaoSocial);
      System.out.println("Email: " + email);
    } catch (Exception e) {
      System.err.println("Erro ao calcular informações da farmácia: " + e.getMessage());
    } finally {
      em.close();
      emf.close();
      Scanner sc = new Scanner(System.in);
      System.out.print("\nPressione Enter para voltar ao menu...");
      sc.nextLine();
      MenuAdm.menuADM();
    }
  }
}
