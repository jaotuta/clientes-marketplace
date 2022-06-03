package com.clientesmarketplace.clientes.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Cliente {

    @Id
    private String idCliente;
    private String nome;
    private String email;
    private String telefone;

}
