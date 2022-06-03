package com.clientesmarketplace.clientes.controllers.router;

import com.clientesmarketplace.clientes.controllers.handler.ClienteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class ClienteRouter {

    @Bean
    public RouterFunction<ServerResponse> router(ClienteHandler clienteHandler) {

        return route().path("/clientes", b1 -> b1
                .nest(accept(MediaType.APPLICATION_JSON), b2 -> b2
                        .GET("", clienteHandler::buscarTodosClientes)
                        .GET("{id}", clienteHandler::buscarPorId)
                        .POST("", clienteHandler::novoCliente)))
                .build();
    }
}
