package com.clientesmarketplace.clientes.repository;

import com.clientesmarketplace.clientes.models.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends ReactiveCrudRepository<Cliente, String> {
}
