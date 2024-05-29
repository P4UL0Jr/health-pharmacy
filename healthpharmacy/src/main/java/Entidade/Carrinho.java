package Entidade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Carrinho {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "cliente_cpf")
  private Cliente cliente;

  @ManyToMany
  @JoinTable(name = "carrinho_produto", joinColumns = @JoinColumn(name = "carrinho_id"), inverseJoinColumns = @JoinColumn(name = "produto_id"))
  private List<Produto> produtos = new ArrayList<>();

  public Carrinho() {
  }
  public Carrinho(Cliente cliente) {
    this.cliente = cliente;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public List<Produto> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<Produto> produtos) {
    this.produtos = produtos;
  }

  public void adicionarProduto(Produto produto) {
    produtos.add(produto);
  }

  public void removerProduto(Produto produto) {
    produtos.remove(produto);
  }
}
