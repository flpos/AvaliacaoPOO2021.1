package model;

import java.io.Serializable;
import java.util.List;

public class Pedido implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private List<ProdutoPedido> produtos;
    private StatusEnum status;

    public Pedido() {
    }

    public Pedido(Integer id, List<ProdutoPedido> produtos, StatusEnum status) {
        this.id = id;
        this.produtos = produtos;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<ProdutoPedido> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoPedido> produtos) {
        this.produtos = produtos;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public void addItem(Produto item) {
        // TODO
    }

    public Produto removeItem(Integer id) {
        // TODO
        return new Produto();
    }

    public Double getTotal() {
        // TODO
        return 0.0;
    }

    public List<ProdutoPedido> getItems() {
        // TODO
        return this.produtos;
    }

}
