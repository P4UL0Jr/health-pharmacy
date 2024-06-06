package Entidade;

import javax.persistence.*;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nome;
    @Column(length = 20)
    private float preco;
    @Column(length = 20)
    private int quantidade;
    @Column(length = 100)
    private String marca;
    @Column(length = 20)
    private String tarja;


    public Produto(String nome, float preco, int quantidade, String marca, String tarja) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.marca = marca;
        this.tarja = tarja;
    }

    public Produto() {

    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }
    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTarja() {
        return tarja;
    }
    public void setTarja(String tarja) {
        this.tarja = tarja;
    }

    @Override
    public String toString() {
        return "ID: " + getId() + "\nNome: " + getNome() + "\nPreco: " + getPreco() + "\nQuantidade: " + getQuantidade() + "\nMarca: " + getMarca() + "\nTarja: " + getTarja() + "\n";
    }

}
