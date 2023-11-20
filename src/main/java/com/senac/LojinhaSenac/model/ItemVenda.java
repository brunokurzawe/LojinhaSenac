package com.senac.LojinhaSenac.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends EntityId {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "desconto")
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "produto=" + produto +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                ", venda=" + venda +
                '}';
    }
}
