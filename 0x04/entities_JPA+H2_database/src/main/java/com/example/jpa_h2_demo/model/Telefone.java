package com.example.jpa_h2_demo.model;

import jakarta.persistence.ManyToOne;

public class Telefone {

    @ManyToOne
    private Cliente cliente;
    
    private int id;
    private String ddd;
    private String numero;
    
    public Telefone(Cliente cliente, int id, String ddd, String numero) {
        this.cliente = cliente;
        this.id = id;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


}
