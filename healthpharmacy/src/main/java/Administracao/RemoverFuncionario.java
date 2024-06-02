package Administracao;

import java.util.Scanner;
import Entidade.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoverFuncionario {
  public static void removerFuncionario() throws InterruptedException {
    Scanner sc = new Scanner(System.in);
    System.out.println("Desligamento de funcionário\n");
    System.out.println("Digite o CPF do funcionário que deseja remover: ");
    System.out.print("--> ");

    String CPF = sc.nextLine();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
    EntityManager em = emf.createEntityManager();
    em.getTransaction().begin();
    Funcionario funcionario = em.find(Funcionario.class, CPF);
    if (funcionario != null) {
      funcionario = em.merge(funcionario);
      em.remove(funcionario);
      em.getTransaction().commit();
      System.out.println("Funcionário "+ funcionario.getNome() +" removido com sucesso!");
      Thread.sleep(2000);
      MenuAdm.menuADM();
    } else {
      System.out.println("Funcionário não encontrado!");
      Thread.sleep(2000);
      MenuAdm.menuADM();
    }

  }

}
