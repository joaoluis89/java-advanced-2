package com.example.demo.gateways.requests;

import jakarta.validation.constraints.NotEmpty;

public class ProfessorRequestDtoPut {

    @NotEmpty
    String nome;
    @NotEmpty
    String materia;
}
