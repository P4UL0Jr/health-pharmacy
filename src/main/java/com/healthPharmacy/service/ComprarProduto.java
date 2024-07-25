package com.healthPharmacy.service;

import java.util.List;
import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import com.healthPharmacy.model.Cliente;
import com.healthPharmacy.model.ItemPedido;
import com.healthPharmacy.model.PedidoFinalizado;
import com.healthPharmacy.model.Produto;

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
                    itemPedido.getProduto().setQuantidade(quantidade);
                    itemPedido.getProduto().setPreco(produto.getPreco());

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
                System.out.println("Produto nao encontrado.");
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
