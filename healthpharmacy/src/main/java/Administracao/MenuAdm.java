package Administracao;

import java.util.Scanner;

import GUI.MenuEntrada;
import Tratamento.Limpeza;

public class MenuAdm {
    public static void menuADM() throws InterruptedException{
        Limpeza.limpeza();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Administração\n");
        Thread.sleep(1500);
        System.out.println("Digite o número da opção desejada:\n");
        System.out.println("[1] Adicionar Funcionário");
        System.out.println("[2] Remover Funcionário");
        System.out.println("[3] Remover Cliente");
        System.out.println("[4] Histórico de vendas");
        System.out.println("[5] Ver clientes cadastrados");
        System.out.println("[6] Ver funcionários cadastrados");
        System.out.println("[7] Retornar ao menu de login");
        System.out.println("[8] Sair do aplicativo\n");
        System.out.print("--> ");

        String opcao = sc.nextLine();
        Limpeza.limpeza();
        switch(opcao){
            case "1":
                AdicionarFuncionario.adicionarFuncionario();
                break;
            case "2":
                RemoverFuncionario.removerFuncionario();
                break;
            case "3":
                RemoverCliente.removerCliente();
                System.out.println();
                break;
            case "4":
                //HistoricoVendas.historicoVendas();
                break;
            case "5":
                VerClientes.verClientes();
                break;
            case "6":
                VerFuncionarios.verFuncionarios();
                break;
            case "7":
                MenuEntrada.menu();
                break;
            case "8":
            System.out.println("Obrigado pela confiança, volte sempre!");
                Thread.sleep(2000);
                System.exit(0);
                sc.close();
                break;
            default:
                sc.nextLine();
                System.out.println("Opção inválida!");
                Thread.sleep(2000);
                menuADM();
                break;
        }

    }
}
