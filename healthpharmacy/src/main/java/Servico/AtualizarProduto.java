package Servico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entidade.Funcionario;
import Entidade.Produto;
import GUI.MenuProdutos;

public class AtualizarProduto {

    public static void atualizarProduto(Funcionario funcionario) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Atualizacao de produto:\n");
        System.out.print("Digite o ID do produto que deseja atualizar: ");
        String id = sc.nextLine();
        Produto produto = em.find(Produto.class, id);

        if (produto == null) {
            System.out.println("Produto nao encontrado!");
            Thread.sleep(2000);
            em.close();
            emf.close();
            MenuProdutos.menuProdutos(funcionario);
            return;
        }

        System.out.println("Dados atuais do produto:");
        System.out.println(produto);

        System.out.print("\nNovo nome (ou pressione Enter para manter o atual): ");
        String novoNome = sc.nextLine();
        if (!novoNome.isEmpty()) {
            produto.setNome(novoNome);
        }

        System.out.print("Novo preço (ou pressione Enter para manter o atual): ");
        String novoPrecoStr = sc.nextLine();
        if (!novoPrecoStr.isEmpty()) {
            try {
                float novoPreco = Float.parseFloat(novoPrecoStr);
                if (novoPreco > 0) {
                    produto.setPreco(novoPreco);
                } else {
                    System.out.println("Preço inválido. Deve ser maior que zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Preço inválido. Digite um número válido.");
            }
        }

        System.out.print("Nova quantidade em estoque (ou pressione Enter para manter o atual): ");
        String novaQuantidadeStr = sc.nextLine();
        if (!novaQuantidadeStr.isEmpty()) {
            try {
                int novaQuantidade = Integer.parseInt(novaQuantidadeStr);
                if (novaQuantidade >= 0) {
                    produto.setQuantidade(novaQuantidade);
                } else {
                    System.out.println("Quantidade inválida. Deve ser maior ou igual a zero.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Quantidade inválida. Digite um número válido.");
            }
        }

        System.out.print("Nova marca (ou pressione Enter para manter o atual): ");
        String novaMarca = sc.nextLine();
        if (!novaMarca.isEmpty()) {
            produto.setMarca(novaMarca);
        }

        System.out.print("Deseja atualizar a tarja? (s/n): ");
        String atualizarTarja = sc.nextLine();
        if (atualizarTarja.equalsIgnoreCase("s")) {
            String novaTarja = CadastroProduto.tarja();
            produto.setTarja(novaTarja);
        }

        try {
            em.getTransaction().begin();
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Produto atualizado com sucesso!");
            
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.err.println("Erro ao atualizar produto: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Pressione Enter para continuar...");
            sc.nextLine();
            MenuProdutos.menuProdutos(funcionario);
        }
    }
}