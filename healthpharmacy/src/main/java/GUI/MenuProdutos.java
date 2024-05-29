package GUI;

import java.util.Scanner;

import Entidade.Funcionario;
import Servico.AtualizarProduto;
import Servico.CadastroProduto;
import Servico.RemoverProduto;
import Servico.VizualizarProduto;
import Tratamento.Limpeza;

public class MenuProdutos {

  public static void menuProdutos(Funcionario funcionario1) throws InterruptedException {
    Scanner sc = new Scanner(System.in);

      System.out.println("Menu de Produtos\n\n");
      Thread.sleep(1500);
      System.out.println("Digite o número da opção desejada:\n");
      System.out.println("[1] Adicionar produto");
      System.out.println("[2] Remover produto");
      System.out.println("[3] Editar produto");
      System.out.println("[4] Visualizar produtos");
      System.out.println("[5] Retornar ao menu anterior");
      System.out.println("[6] Sair do aplicativo");

      System.out.print("--> ");
      String escolha = sc.nextLine();
      Limpeza.limpeza();
      switch (escolha) {
        case "1":

          CadastroProduto.cadastroProduto();
          break;
        case "2":
          RemoverProduto.removerProduto();
          break;
        case "3":
          AtualizarProduto.atualizarProduto();
          break;
        case "4":
          VizualizarProduto.vizualizarProduto();
          break;
        case "5":
          MenuFuncionario.menuFuncionario(funcionario1);
          break;
        case "6":
          System.out.println("Obrigado pela confiança, volte sempre!");
          Thread.sleep(2000);
          sc.close();
          System.exit(0);
          break;
        default:
          sc.nextLine();
          System.out.println("Digite uma opção válida!");
          menuProdutos(funcionario1);
      }
  }
}
