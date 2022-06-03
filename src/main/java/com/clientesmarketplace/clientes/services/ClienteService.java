package com.clientesmarketplace.clientes.services;

import com.clientesmarketplace.clientes.dto.ClienteRequest;
import com.clientesmarketplace.clientes.models.Cliente;
import com.clientesmarketplace.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public Mono<Cliente> novoCliente(Cliente cliente){

        return clienteRepository.save(cliente);
    }

    public Flux<Cliente> todosClientes() {
        return clienteRepository.findAll();
    }

    public Mono<Cliente> buscarClientePorId(String id) {
        return clienteRepository.findById(id).switchIfEmpty(Mono.error(new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado")));
    }


}
