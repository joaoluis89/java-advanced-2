package com.example.demo.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Pessoa {

    @Id
    private PessoaId pessoaId;
}
