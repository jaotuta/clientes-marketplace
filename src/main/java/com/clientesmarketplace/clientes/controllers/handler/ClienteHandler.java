package com.clientesmarketplace.clientes.controllers.handler;

import com.clientesmarketplace.clientes.dto.ClienteRequest;
import com.clientesmarketplace.clientes.models.Cliente;
import com.clientesmarketplace.clientes.services.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

@Component
@RequiredArgsConstructor
public class ClienteHandler {

    private final ClienteService clienteService;

    public Mono<ServerResponse> buscarTodosClientes(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.todosClientes(), Cliente.class);
    }

    public Mono<ServerResponse> buscarPorId(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(clienteService.buscarClientePorId(id), Cliente.class);
    }

    public Mono<ServerResponse> novoCliente(ServerRequest serverRequest) {

        Mono<Cliente> clienteMono = serverRequest.bodyToMono(Cliente.class);

        return ServerResponse.status(HttpStatus.CREATED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(clienteMono.flatMap(clienteService::novoCliente), Cliente.class));
    }



}
