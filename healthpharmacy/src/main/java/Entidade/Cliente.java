package Entidade;

import java.io.Serial;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Cliente extends Pessoa implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(length = 11)
	private String CPF;
    @Column(length = 3)
    private int idade;
    @Column(length = 100)
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
