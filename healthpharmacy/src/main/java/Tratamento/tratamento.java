package Tratamento;

public class tratamento {
    public static void contaInvalida() throws InterruptedException{
        System.out.println("Login ou Senha incorretos! tente novamente");
        Thread.sleep(2000);
    }
    public static void contaJaExiste() throws InterruptedException{
        System.out.println("Esses dados já estão cadastrados no aplicativo, tente novamente ou faça login");
    }
    public static void valorInvalido() throws InterruptedException{
        System.out.println("Valor Inválido, tente novamente");
        Thread.sleep(2000);
    }
    public static void opcaoInvalida() throws InterruptedException{
        System.out.println("Digite uma opção válida!");
        Thread.sleep(2000);
    }
    public static void cpfInvalido() throws InterruptedException{
        System.out.println("Digite um CPF válido!");
        Thread.sleep(2000);
    }
    public static void CPFInvalido() throws InterruptedException{
        System.out.println("Digite um CPF válido");
        Thread.sleep(2000);
    }
    public static void SQLInvalido() throws InterruptedException{
        System.out.println("Erro ao conectar com o banco de dados, tente novamente");
        Thread.sleep(2000);
    }


}