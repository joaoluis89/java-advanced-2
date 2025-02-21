package com.example.demo.gateways.clients;

import com.example.demo.gateways.clients.response.EstadoResponse;
import com.example.demo.gateways.clients.response.MunicipioResponse;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ibgeFeign2", url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados")
public interface IbgeLocalidadesClient {

    @GetMapping
    List<EstadoResponse> getAllEstados();


    @GetMapping("/{uf}/municipios")
    List<MunicipioResponse> getAllMunicipiosPorEstado(@PathVariable String uf);
}
