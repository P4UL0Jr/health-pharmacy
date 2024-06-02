package Servico;

import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;

import Entidade.Funcionario;
import GUI.MenuEntrada;
import GUI.MenuFuncionario;
import Tratamento.tratamento;

public class LoginFuncionario {

    public static void loginFuncionario() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        System.out.println("Login do Funcionario\n");
        Thread.sleep(1000);

        System.out.print("CPF: ");
        String cpf = sc.nextLine().replaceAll("[^0-9]", "");

        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Funcionario funcionario = em.createQuery(
                "SELECT f FROM Funcionario f WHERE f.CPF = :cpf AND f.senha = :senha", Funcionario.class
            )
            .setParameter("cpf", cpf)
            .setParameter("senha", senha)
            .getSingleResult();

            System.out.println("Login realizado com sucesso!");
            Thread.sleep(1500);
            em.close();
            emf.close();
            MenuFuncionario.menuFuncionario(funcionario);
        } catch (NoResultException e) {
            tratamento.contaInvalida();
            em.close();
            emf.close();
            MenuEntrada.menuLogin();
        }
    }
}