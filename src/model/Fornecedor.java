package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Fornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String nome;
    private String login;
    private List<Produto> produtos = new ArrayList<Produto>();

    public Fornecedor() {
    }

    public Fornecedor(Integer id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Fornecedor(Integer id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

}
