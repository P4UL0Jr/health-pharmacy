package Administracao;

import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import Entidade.Funcionario;

public class VerFuncionarios {
    public static void verFuncionarios() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Funcionários cadastrados\n");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Funcionario> query = em.createQuery("SELECT f FROM Funcionario f", Funcionario.class);
            List<Funcionario> funcionarios = query.getResultList();

            if (funcionarios.isEmpty()) {
                System.out.println("Não há funcionários cadastrados.");
            } else {
                System.out.println("\nLista de Funcionários:");
                for (Funcionario funcionario : funcionarios) {
                    System.out.println(funcionario);
                }
            }
        } finally {
            em.close();
            emf.close();
        }
        System.out.println("Pressione enter para retornar ao menu de administração.");
        sc.nextLine();
        MenuAdm.menuADM();
    }
}
