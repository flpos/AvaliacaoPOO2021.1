package model;

import java.io.Serializable;

public class ProdutoPedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer quantidade;
    private Produto produto;

    public ProdutoPedido() {
    }

    public ProdutoPedido(Integer quantidade, Produto produto) {
        this.quantidade = quantidade;
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getSubTotal() {
        return this.produto.getPreco() * this.quantidade;
    }
}
