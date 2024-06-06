package GUI;

import java.util.Scanner;
import Entidade.Funcionario;
import Servico.AtualizarProduto;
import Servico.CadastroProduto;
import Servico.RemoverProduto;
import Servico.VizualizarProduto;
import Tratamento.Limpeza;
import Tratamento.tratamento;

public class MenuProdutos {

  public static void menuProdutos(Funcionario funcionario) throws InterruptedException {
    Scanner sc = new Scanner(System.in);
      Limpeza.limpeza();
      System.out.println("Menu de Produtos\n\n");
      Thread.sleep(1500);
      System.out.println("Digite o número da opção desejada:\n");
      System.out.println("[1] Adicionar produto");
      System.out.println("[2] Remover produto");
      System.out.println("[3] Editar produto");
      System.out.println("[4] Visualizar produtos");
      System.out.println("[5] Retornar ao menu anterior");
      System.out.println("[6] Sair do aplicativo\n");

      System.out.print("--> ");
      String escolha = sc.nextLine();
      Limpeza.limpeza();
      switch (escolha) {
        case "1":
          CadastroProduto.cadastroProduto(funcionario);
          break;
        case "2":
          RemoverProduto.removerProduto(funcionario);
          break;
        case "3":
          AtualizarProduto.atualizarProduto(funcionario);
          break;
        case "4":
          VizualizarProduto.visualizarProdutosDisponiveis();
          menuProdutos(funcionario);
          break;
        case "5":
          MenuFuncionario.menuFuncionario(funcionario);
          break;
        case "6":
          System.out.println("Obrigado pela confianca, volte sempre!");
          Thread.sleep(2000);
          sc.close();
          System.exit(0);
          break;
        default:
          tratamento.opcaoInvalida();
          menuProdutos(funcionario);
      }
  }
}
