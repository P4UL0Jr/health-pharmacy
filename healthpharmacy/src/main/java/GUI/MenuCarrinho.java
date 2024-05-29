package GUI;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import Entidade.Carrinho;
import Entidade.Cliente;
import Servico.AdicionarProdutoCarrinho;
import Servico.RemoverProdutoCarrinho;
import Servico.VizualizarCarrinho;

public class MenuCarrinho {
    public static void menuCarrinho(Cliente cliente, EntityManager em) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Carrinho carrinho;
        try {
            carrinho = em.createQuery("SELECT c FROM Carrinho c WHERE c.cliente = :cliente", Carrinho.class).setParameter("cliente", cliente).getSingleResult();
        } catch (NoResultException e) {
            carrinho = new Carrinho(cliente);
            em.getTransaction().begin();
            em.persist(carrinho);
            em.getTransaction().commit();
        }

        String opcao = "1";
        do {
            System.out.println("\nCarrinho de compras\n");
            System.out.println("1 - Adicionar produto ao carrinho");
            System.out.println("2 - Remover produto do carrinho");
            System.out.println("3 - Visualizar carrinho");
            System.out.println("4 - Finalizar compra");
            System.out.println("0 - Voltar");
            System.out.print("--> ");
            opcao = sc.nextLine();

            switch (opcao) {
                case "1":
                    AdicionarProdutoCarrinho.adicionarProdutoCarrinho(carrinho, em);
                    break;
                case "2":
                    RemoverProdutoCarrinho.removerProdutoCarrinho(carrinho, em);
                    break;
                case "3":
                    VizualizarCarrinho.visualizarCarrinho(carrinho);
                    break;
                case "4":
                    break;
                case "5":
                    System.out.println("Voltando ao menu anterior...");
                    Thread.sleep(1500);
                    opcao = "0";
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != "0");
    }
}
