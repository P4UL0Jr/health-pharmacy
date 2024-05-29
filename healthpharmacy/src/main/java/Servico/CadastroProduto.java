package Servico;

import java.util.Scanner;


public class CadastroProduto {
    

    public static void cadastroProduto() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Cadastrar novo Produto: \n");
        Thread.sleep(1000);
    }

    public static String tarja() throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String tarja = null;
        System.out.println("Qual a tarja do medicamento");
        System.out.println(" [1]-Sem tarja\n [2]-tarja amarela\n [3]-tarja vermelha\n [4]tarja preta");

        System.out.print("--> ");
        String escolha = sc.nextLine();
        switch (escolha) {
            case "1":
                tarja = "Sem tarja";
                break;
            case "2":
                tarja = "Tarja amarela";
                break;
            case "3":
                tarja = "Tarja vermelha";
                break;
            case "4":
                tarja = "Tarja preta";
                break;
            default:
                System.out.println("Digite uma opção válida!");
                tarja();

        }

        return tarja;

    }
}
