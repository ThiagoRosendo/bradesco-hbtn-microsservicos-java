package com.example.jpa_h2_demo.model;

import java.util.List;

import jakarta.persistence.OneToMany;

public class Cliente {
    private int id;
    private String nome;
    private int idade;
    private String email;

    @OneToMany
    private List<Telefone> telefones;
    
    @OneToMany
    private List<Endereco> enderecos;

    
    public Cliente(int id, String nome, int idade, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    
}
