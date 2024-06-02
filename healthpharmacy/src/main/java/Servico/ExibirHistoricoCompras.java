package Servico;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Entidade.Cliente;
import Entidade.ItemPedido;
import Entidade.PedidoFinalizado;

public class ExibirHistoricoCompras {
  public static void exibirHistoricoCompras(Cliente cliente) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();

    TypedQuery<PedidoFinalizado> query = em.createQuery("SELECT p FROM PedidoFinalizado p WHERE p.cliente = :cliente",
        PedidoFinalizado.class);
    query.setParameter("cliente", cliente);
    List<PedidoFinalizado> pedidos = query.getResultList();

    if (pedidos.isEmpty()) {
      System.out.println("Você ainda nao fez nenhuma compra.");
    } else {
      System.out.println("Historico de Compras:");
      for (PedidoFinalizado pedido : pedidos) {
        System.out.println("\n------------------------");
        System.out.println("Pedido #" + pedido.getId());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"); // Define o formato desejado
        String dataFormatada = pedido.getDataHora().format(formatter);
        System.out.println("Data: " + dataFormatada);
        System.out.println("Valor Total: R$ " + String.format("%.2f", pedido.getValorTotal()));

        for (ItemPedido item : pedido.getItens()) {
          System.out.println("Produto: " + item.getProduto().getNome() + "\nMarca:" + item.getProduto().getMarca() + "\nQuantidade: " + item.getQuantidade() + "\n");
        }
      }
    }

    em.close();
    emf.close();
    Scanner sc = new Scanner(System.in);
    System.out.print("\nPressione Enter para voltar ao menu anterior.");
    sc.nextLine();
  }
}
