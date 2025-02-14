package com.example.demo.gateways.clients.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EstadoResponse {

    private String id;
    private String nome;
    private String sigla;
}
