package Administracao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Entidade.Funcionario;
import Tratamento.tratamento;

public class AdicionarFuncionario {
    public static void adicionarFuncionario() throws InterruptedException {
      Scanner sc = new Scanner(System.in);
      System.out.println("Adicionar Funcionário\n");
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
      EntityManager em = emf.createEntityManager();
      System.out.print("CPF: ");
      String CPF = sc.nextLine();
      CPF = CPF.replaceAll("[^0-9]", "");
      if (CPF.length() != 11) {
          tratamento.CPFInvalido();
          MenuAdm.menuADM();
      }
      Funcionario funcionarioExistente = em.createQuery("SELECT f FROM Funcionario f WHERE f.CPF = :CPF", Funcionario.class).setParameter("cpfCnpj", CPF).getSingleResult();
      if (funcionarioExistente != null) {
          tratamento.contaJaExiste();
          em.close();
          emf.close();
          MenuAdm.menuADM();
      }
      System.out.print("Nome: ");
      String nome = sc.nextLine();
      System.out.print("Telefone(ex: 99999 9999): ");
      String telefone = sc.nextLine();
      telefone = telefone.replaceAll("[^0-9]", "");
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
      System.out.println("Funcionário adicionado com sucesso!");
      em.close();
      emf.close();
      Thread.sleep(2000);
      MenuAdm.menuADM();
      

    }

}
