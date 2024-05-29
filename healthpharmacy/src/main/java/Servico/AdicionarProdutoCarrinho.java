package Servico;

import java.util.Scanner;
import javax.persistence.EntityManager;
import Entidade.Carrinho;
import Entidade.Produto;

public class AdicionarProdutoCarrinho {
  public static void adicionarProdutoCarrinho(Carrinho carrinho, EntityManager em) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite o ID do produto que deseja adicionar: ");
    String idProdutoStr = sc.nextLine();

    try {
        Long idProduto = Long.parseLong(idProdutoStr);
        Produto produto = em.find(Produto.class, idProduto);

        if (produto != null) {
            if (produto.getQuantidade() > 0) {
                System.out.print("Digite a quantidade desejada: ");
                int quantidade = sc.nextInt();
                sc.nextLine();

                if (quantidade > 0 && quantidade <= produto.getQuantidade()) {
                    @SuppressWarnings("unlikely-arg-type")
                    Produto produtoNoCarrinho = carrinho.getProdutos().stream()
                            .filter(p -> p.getId().equals(idProduto))
                            .findFirst()
                            .orElse(null);

                    if (produtoNoCarrinho != null) {
                        produtoNoCarrinho.setQuantidade(produtoNoCarrinho.getQuantidade() + quantidade);
                    } else {
                        produto.setQuantidade(quantidade); 
                        carrinho.adicionarProduto(produto);
                    }

                    em.getTransaction().begin();
                    em.merge(carrinho);
                    em.getTransaction().commit();

                    produto.setQuantidade(produto.getQuantidade() - quantidade);
                    em.getTransaction().begin();
                    em.merge(produto); 
                    em.getTransaction().commit();

                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                } else {
                    System.out.println("Quantidade inválida ou insuficiente no estoque.");
                }
            } else {
                System.out.println("Produto sem estoque disponível.");
            }
        } else {
            System.out.println("Produto não encontrado.");
        }
    } catch (NumberFormatException e) {
        System.out.println("ID do produto ou quantidade inválidos.");
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        System.err.println("Erro ao adicionar produto ao carrinho: " + e.getMessage());
    }
}

}
