package Servico;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import Entidade.Cliente;
import GUI.MenuCliente;
import GUI.MenuEntrada;
import Tratamento.tratamento;

public class CadastroCliente {

    public static void cadastroCliente() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Cadastro de Cliente:\n");

        System.out.print("CPF: ");
        String CPF = sc.nextLine().replaceAll("[^0-9]", "");
        if (CPF.length() != 11) {
            tratamento.CPFInvalido();
            MenuEntrada.menuRegistro();
        }

        try {
            @SuppressWarnings("unused")
            Cliente clienteExistente = em.createQuery("SELECT c FROM Cliente c WHERE c.CPF = :CPF", Cliente.class)
                    .setParameter("CPF", CPF)
                    .getSingleResult();
            tratamento.contaJaExiste();
            em.close();
            emf.close();
            MenuEntrada.menuRegistro();
        } catch (NoResultException e) {
            // Cliente não encontrado, pode prosseguir com o cadastro
        }

        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Endereco: ");
        String endereco = sc.nextLine();
        System.out.print("Idade: ");
        int idade;
        while (true) {
            System.out.print("Idade: ");
            try {
                idade = Integer.parseInt(sc.nextLine().replaceAll("[^0-9]", ""));
                if (idade < 18) {
                    throw new IllegalArgumentException("Voce deve ter mais de 18 anos para se cadastrar.");
                }
                break;
            } catch (NumberFormatException e) {
                tratamento.valorInvalido();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        String telefone;
        while (true) {
            System.out.print("Telefone (ex: 8199999 9999): ");
            telefone = sc.nextLine().replaceAll("[^0-9]", "");

            if (telefone.length() != 11) {
                System.out.println("Telefone invalido. o telefone deve conter 11 dígitos.");
            } else {
                break;
            }
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        Cliente cliente = new Cliente(nome, email, idade, endereco, telefone, senha, CPF);
        em.getTransaction().begin();
        em.persist(cliente);
        em.getTransaction().commit();
        System.out.println("Cliente cadastrado com sucesso!");
        em.close();
        emf.close();
        Thread.sleep(2000);
        MenuCliente.menuCliente(cliente);
    }
}
