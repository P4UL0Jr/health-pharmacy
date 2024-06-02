package Entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Funcionario extends Pessoa{
    @Column(length = 50)
    private String cargo;
    @Id
    @Column(length = 11)
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
        return "Nome: " + getNome() + "\nCargo: " + getCargo() + "\nCPF: " + getCPF() + "\nTelefone: " + getTelefone() + "\nEmail: " + getEmail() + "\nSenha: " + getSenha()+ "\n";
    }

    
}
