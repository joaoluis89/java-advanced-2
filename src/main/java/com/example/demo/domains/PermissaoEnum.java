package com.example.demo.domains;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public enum PermissaoEnum {


    ROLE_USUARIO(new ArrayList<>()),
    ROLE_ALUNO(List.of("ESTUDA")),
    ROLE_PROFESSOR(List.of("LECIONA"));

    private List<String> autoridades;

    PermissaoEnum(List<String> autoridades) {
        this.autoridades = autoridades;
    }


}
