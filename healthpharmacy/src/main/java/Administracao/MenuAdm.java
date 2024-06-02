package Administracao;

import java.util.Scanner;

import GUI.MenuEntrada;
import Tratamento.Limpeza;
import Tratamento.tratamento;

public class MenuAdm {
    public static void menuADM() throws InterruptedException{
        Limpeza.limpeza();
        Scanner sc = new Scanner(System.in);
        System.out.println("Menu de Administracao\n");
        Thread.sleep(1500);
        System.out.println("Digite o numero da opcao desejada:\n");
        System.out.println("[1] Adicionar Funcionario");
        System.out.println("[2] Remover Funcionario");
        System.out.println("[3] Remover Cliente");
        System.out.println("[4] Informacao da Farmacia");
        System.out.println("[5] Ver clientes cadastrados");
        System.out.println("[6] Ver funcionarios cadastrados");
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
                InformacaoFarmacia.informacaoFarmacia();
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
            System.out.println("Obrigado pela confianca, volte sempre!");
                Thread.sleep(2000);
                System.exit(0);
                sc.close();
                break;
            default:
                tratamento.opcaoInvalida();
                Thread.sleep(2000);
                menuADM();
                break;
        }

    }
}
