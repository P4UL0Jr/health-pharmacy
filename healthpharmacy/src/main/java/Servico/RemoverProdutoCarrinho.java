package Servico;

import javax.persistence.EntityManager;
import java.util.Scanner;
import Entidade.Carrinho;
import Entidade.Produto;

public class RemoverProdutoCarrinho {
  public static void removerProdutoCarrinho(Carrinho carrinho, EntityManager em) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Digite o ID do produto que deseja remover: ");
    String idProdutoStr = sc.nextLine();

    try {
        Long idProduto = Long.parseLong(idProdutoStr);
        @SuppressWarnings("unlikely-arg-type")
        Produto produtoRemover = carrinho.getProdutos().stream()
                .filter(p -> p.getId().equals(idProduto))
                .findFirst()
                .orElse(null);

        if (produtoRemover != null) {
            carrinho.removerProduto(produtoRemover);
            em.getTransaction().begin();
            em.merge(carrinho);
            em.getTransaction().commit();

            System.out.println("Produto removido do carrinho com sucesso!");
        } else {
            System.out.println("Produto não encontrado no carrinho.");
        }
    } catch (NumberFormatException e) {
        System.out.println("ID do produto inválido.");
    } catch (Exception e) {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
        System.err.println("Erro ao remover produto do carrinho: " + e.getMessage());
    }
}

}
