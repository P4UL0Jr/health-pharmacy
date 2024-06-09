package Servico;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidade.Cliente;
import Entidade.ItemPedido;
import Entidade.PedidoFinalizado;
import Entidade.Produto;

public class ComprarProduto {

    public static void comprarProduto(Cliente cliente) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o ID do produto que deseja comprar: ");
        String idProdutoStr = sc.nextLine();

        try {
            Long idProduto = Long.parseLong(idProdutoStr);

            Produto produto = em.find(Produto.class, idProduto);

            if (produto != null) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = sc.nextInt();
                sc.nextLine();

                if (quantidade > 0 && quantidade <= produto.getQuantidade()) {
                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setProduto(produto);
                    itemPedido.setQuantidade(quantidade);
                    itemPedido.setPreco(produto.getPreco());

                    PedidoFinalizado pedido = new PedidoFinalizado(cliente, List.of(itemPedido));

                    em.getTransaction().begin();
                    em.persist(pedido);
                    em.persist(itemPedido);
                    em.getTransaction().commit();

                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    em.getTransaction().begin();
                    em.merge(produto);
                    em.getTransaction().commit();

                    System.out.println("Compra realizada com sucesso!");
                } else {
                    System.out.println("Quantidade invalida ou insuficiente no estoque.");
                }
            } else {
                System.out.println("Produto não encontrado no sistema");
            }
        } catch (NumberFormatException e) {
            System.out.println("ID do produto ou quantidade invalidos.");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao realizar a compra: " + e.getMessage());
        }
        em.close();
        emf.close();
        Thread.sleep(1500);
        System.out.print("\nPressione Enter para voltar ao menu anterior.");
        sc.nextLine();
    }
}
