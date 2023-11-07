package com.senac.LojinhaSenac.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Pessoa extends EntityId{

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "endereco", nullable = false)
    private String endereco;
    @Column(name = "email", nullable = false)
    private String email;

    //getters e setters

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEmail() {
        return email;
    }

}
