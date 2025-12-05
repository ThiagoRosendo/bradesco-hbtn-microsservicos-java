package com.example.jpa_h2_demo.repository;

public interface ClienteRepository {

    void addClient(Cliente cliente);

    List<Cliente> findAllClients();

    Cliente findClientById(Long id);

    void removerCliente(Long id);

    void updateCliente(Long id, Cliente cliente);
}
