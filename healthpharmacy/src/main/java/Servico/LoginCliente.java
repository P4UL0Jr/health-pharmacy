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

public class LoginCliente {

    public static void loginCliente() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Login de Cliente\n");
        Thread.sleep(1000);

        System.out.print("CPF: ");
        String cpf = sc.nextLine().replaceAll("[^0-9]", "");

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Cliente cliente = em.createQuery(
                "SELECT c FROM Cliente c WHERE c.CPF = :cpf AND c.senha = :senha", Cliente.class
            )
            .setParameter("cpf", cpf)
            .setParameter("senha", senha)
            .getSingleResult();

            em.close();
            emf.close();
            System.out.println("Login realizado com sucesso!");
            Thread.sleep(1500);
            MenuCliente.menuCliente(cliente);
        } catch (NoResultException e) {
            tratamento.contaInvalida();
            em.close();
            emf.close();
            MenuEntrada.menuLogin();
        }
    }
}