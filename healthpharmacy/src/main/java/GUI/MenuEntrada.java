package GUI;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Administracao.MenuAdm;
import Servico.CadastroCliente;
import Servico.LoginCliente;
import Servico.LoginFuncionario;
import Tratamento.*;

public class MenuEntrada {

    // Menu Inicial
    public static void menu() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Limpeza.limpeza();
        System.out.println("  HEALTH  PHARMACY\n");
        Thread.sleep(2000);

        System.out.println("Digite o numero da opcao desejada:\n");
        System.out.println("[1] Se Registrar");
        System.out.println("[2] Logar");
        System.out.println("[3] area da Administracao");
        System.out.println("[4] Sair do Aplicativo\n");

        System.out.print("--> ");
        String escolha = sc.nextLine();

        Limpeza.limpeza();
        switch (escolha) {
            case "1":
                menuRegistro();
                break;
            case "2":
                menuLogin();
                break;
            case "3":
                MenuAdm.menuADM();
                break;
            case "4":
                System.out.println("Obrigado pela confianca, volte sempre!");
                Thread.sleep(2000);
                sc.close();
                System.exit(0);
            default:
                tratamento.opcaoInvalida();
                menu();
        }
    }

    // Menu de Login
    public static void menuLogin() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Limpeza.limpeza();
        System.out.println("Menu de Login\n");
        Thread.sleep(1500);
        System.out.println("Digite o numero da opcao desejada:\n");
        System.out.println("[1] Entrar como cliente");
        System.out.println("[2] Entrar como Funcionario");
        System.out.println("[3] retornar ao menu anterior\n");

        System.out.print("--> ");
        String escolha = sc.nextLine();
        Limpeza.limpeza();
        switch (escolha) {
            case "1":
                LoginCliente.loginCliente();
                break;
            case "2":
                LoginFuncionario.loginFuncionario();
                break;
            case "3":
                menu();
                break;
            default:
                tratamento.opcaoInvalida();
                menuLogin();
                break;
        }
    }

    // Menu de Registro
    public static void menuRegistro() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        Limpeza.limpeza();
        System.out.println("Menu de Registro\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opcao desejada:\n");
        System.out.println("[1] se Registrar como cliente");
        System.out.println("[2] retornar ao menu anterior\n");

        System.out.print("--> ");
        String escolha = sc.nextLine();
        Limpeza.limpeza();
        switch (escolha) {
            case "1":
                CadastroCliente.cadastroCliente();
                break;
            case "2":
                menu();
                break;
            default:
                tratamento.opcaoInvalida();
                menuRegistro();
                break;
        }
    }

    // Start no APP
    public static void main(String[] args) throws InterruptedException {
        Limpeza.limpeza();

        EntityManagerFactory emf = null;
        EntityManager em = null;

        int tentativas = 2;
        while (tentativas > 0) {
            try {
                emf = Persistence.createEntityManagerFactory("jpa");
                em = emf.createEntityManager();
                em.getTransaction().begin();
                em.getTransaction().commit();
                break;
            } catch (Exception e) {
                tentativas--;
                System.err.println("Erro ao conectar ao banco de dados. Tentando novamente...");
                Thread.sleep(2000);
            } finally {
                if (em != null) {
                    em.close();
                }
            }
        }

        if (emf != null) {
            menu();
        } else {
            tratamento.SQLInvalido();
            Thread.sleep(2000);
            System.exit(0);
        }
    }
}