package Entidade;

import javax.persistence.*;

@Entity
public class ItemPedido {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "produto_id")
  private Produto produto;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private PedidoFinalizado pedido;

  private int quantidade;
  private double preco;

  public ItemPedido() {
  }

  public ItemPedido(Long id, Produto produto, int quantidade, double preco) {
    this.id = id;
    this.produto = produto;
    this.quantidade = quantidade;
    this.preco = preco;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Produto getProduto() {
    return produto;
  }

  public PedidoFinalizado getPedido() {
    return pedido;
  }
  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return quantidade;
  }

  public void setQuantidade(int quantidade) {
    this.quantidade = quantidade;
  }

  public double getPreco() {
    return preco;
  }

  public void setPreco(double preco) {
    this.preco = preco;
  }

  
}
