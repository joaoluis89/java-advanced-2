package com.example.demo.gateways.clients.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MunicipioResponse {

    private String id;

    @JsonProperty("nome")
    private String name;
}
