package Administracao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import Entidade.Funcionario;
import Tratamento.tratamento;

public class AdicionarFuncionario {
    public static void adicionarFuncionario() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Adicionar Funcionario\n");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();
        System.out.print("CPF: ");
        String CPF = sc.nextLine();
        CPF = CPF.replaceAll("[^0-9]", "");
        if (CPF.length() != 11) {
            tratamento.CPFInvalido();
            MenuAdm.menuADM();
        }

        try {
            Funcionario funcionarioExistente = em.createQuery("SELECT f FROM Funcionario f WHERE f.CPF = :CPF", Funcionario.class).setParameter("CPF", CPF).getSingleResult();
            tratamento.contaJaExiste();
            em.close();
            emf.close();
            MenuAdm.menuADM();
        } catch (NoResultException e) {
            // Funcionário não encontrado, pode prosseguir com o cadastro
        }
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        String telefone;
        while (true) {
            System.out.print("Telefone (ex: (81)99999 9999): ");
            telefone = sc.nextLine().replaceAll("[^0-9]", "");

            if (telefone.length() == 11) {
                telefone = telefone.substring(0, 5) + " " + telefone.substring(5);
                break;
            } else {
                System.out.println("Telefone inválido. Digite 11 dígitos.");
            }
        }
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();
        System.out.print("Cargo: ");
        String cargo = sc.nextLine();
        Funcionario funcionario = new Funcionario(nome, email, telefone, cargo, senha, CPF);
        em.getTransaction().begin();
        em.persist(funcionario);
        em.getTransaction().commit();
        System.out.println("Funcionario adicionado com sucesso!");
        em.close();
        emf.close();
        Thread.sleep(2000);
        MenuAdm.menuADM();

    }

}
