package com.example.loja.model;

import lombok.Getter;
import lombok.Setter;

//@Entity (tb_name = "produtos")
public class Produto {

    private Long id;
    private String nome;
    private int qtde; //quantidade do produto.
    private double preco;

    public Produto(){
    }
    public Produto(Long id, String nome, double preco, int qtde){
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.qtde = qtde;
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

    public int getQtde() {
        return qtde;
    }

    public void setQtde(int qtde) {
        this.qtde = qtde;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
