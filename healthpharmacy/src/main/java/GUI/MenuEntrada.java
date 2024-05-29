package GUI;

import java.util.Scanner;
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

        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Se Registrar");
        System.out.println("[2] Logar");
        System.out.println("[3] Área da Administração");
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
                System.out.println("Obrigado pela confiança, volte sempre!");
                Thread.sleep(2000);
                sc.close();
                System.exit(0);
            default:
                sc.nextLine();
                tratamento.opcaoInvalida();
                menu();
        }
    }

    // Menu de Login
    public static void menuLogin() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Login\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Entrar como cliente");
        System.out.println("[2] Entrar como Funcionário");
        System.out.println("[3] retornar ao menu anterior\n");

        System.out.print("--> ");
        int escolha = sc.nextInt();
        Limpeza.limpeza();
        switch (escolha) {
            case 1:
                LoginCliente.loginCliente();
                break;
            case 2:
                LoginFuncionario.loginFuncionario();
                break;
            case 3:
                menu();
                break;
            default:
                sc.nextLine();
                tratamento.opcaoInvalida();
                menuLogin();
                break;
        }
    }

    // Menu de Registro
    public static void menuRegistro() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Registro\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] se Registrar como cliente");
        System.out.println("[2] retornar ao menu anterior\n");

        System.out.print("--> ");
        int escolha = sc.nextInt();
        Limpeza.limpeza();
        switch (escolha) {
            case 1:
                CadastroCliente.cadastroCliente();
                break;
            case 2:
                menu();
                break;
            default:
                sc.nextLine();
                tratamento.opcaoInvalida();
                menuRegistro();
                break;
        }
    }

    // Start no APP
    public static void main(String[] args) throws InterruptedException {
        Limpeza.limpeza();
        menu();

    }
}