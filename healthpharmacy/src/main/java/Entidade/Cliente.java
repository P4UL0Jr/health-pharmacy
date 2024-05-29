package Entidade;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente extends Pessoa implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
	private String CPF;
    private int idade;
    private String endereco;

    public Cliente(){
    }

    public Cliente(String nome,String email,int idade, String endereco,String telefone,String senha, String CPF) {
        super(nome, telefone, email, senha);
        this.idade = idade;
        this.endereco = endereco;
        this.CPF = CPF;

    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nCPF: " + getCPF() + "\nTelefone: " + getTelefone() + "\nIdade: " + getIdade() + "\nEmail: " + getEmail() + "\nEndereco: " + getEndereco() + "\nSenha: " + getSenha()+ "\n";
    }
    
    
}
