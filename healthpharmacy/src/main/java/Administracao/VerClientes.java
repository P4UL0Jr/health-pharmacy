package Administracao;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import Entidade.Cliente;

public class VerClientes {
    public static void verClientes() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Clientes cadastrados:\n");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Cliente> query = em.createQuery("SELECT c FROM Cliente c", Cliente.class);
            List<Cliente> clientes = query.getResultList();
            if (clientes.isEmpty()) {
                System.out.println("Nao ha clientes cadastrados.");
            } else {
                System.out.println("Lista de Clientes:");
                for (Cliente cliente : clientes) {
                    System.out.println(cliente);
                }
            }
        } finally {
            em.close();
            emf.close();
        }
        System.out.println("Pressione enter para retornar ao menu de administracao.");
        sc.nextLine();
        MenuAdm.menuADM();
    }

}
