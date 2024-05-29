package Entidade;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario extends Pessoa{
    private String cargo;
    @Id
    private String CPF;

    public Funcionario(){
    }
    
    public Funcionario(String nome,String email,String telefone,String cargo, String senha, String CPF){
        super(nome, telefone, email, senha);
        this.cargo = cargo;
        this.CPF = CPF;
    }


    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCPF() {
        return CPF;
    }
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }


    @Override
    public String toString() {
        return "Nome: \" + getNome() + Cargo: " + getCargo() + "\nCPF: " + getCPF() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha()+ "\n";
    }

    
}
