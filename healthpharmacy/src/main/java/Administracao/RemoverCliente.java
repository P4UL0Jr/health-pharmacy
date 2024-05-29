package Administracao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import Entidade.Cliente;

public class RemoverCliente {
  public static void removerCliente() throws InterruptedException{
    Scanner sc = new Scanner(System.in);
    System.out.println("Desligamento de cliente\n");
    System.out.println("Digite o CPF do cliente que deseja remover: ");
    System.out.print("--> ");

    String CPF = sc.nextLine();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Cliente cliente = em.find(Cliente.class, CPF);
    if (cliente != null) {
      cliente = em.merge(cliente);
      em.remove(cliente);
      em.getTransaction().commit();
      System.out.println("Cliente "+ cliente.getNome() +" removido com sucesso!");
      Thread.sleep(2000);
      MenuAdm.menuADM();
    } else {
      System.out.println("Cliente não encontrado!");
      Thread.sleep(2000);
      MenuAdm.menuADM();
    }
  }
}
