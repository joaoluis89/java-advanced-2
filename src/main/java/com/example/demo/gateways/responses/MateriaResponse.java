package com.example.demo.gateways.responses;

import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class MateriaResponse extends RepresentationModel<MateriaResponse> {

    private String descricao;

}
