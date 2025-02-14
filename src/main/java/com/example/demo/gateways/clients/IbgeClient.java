package com.example.demo.gateways.clients;

import com.example.demo.gateways.clients.response.EstadoResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ibge", url = "https://servicodados.ibge.gov.br")
public interface IbgeClient {

    @GetMapping("/api/v1/localidades/estados")
    List<EstadoResponse> getAllEstados();
}
