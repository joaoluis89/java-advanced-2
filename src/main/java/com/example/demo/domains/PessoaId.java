package com.example.demo.domains;

import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class PessoaId {

    @OneToOne
    private Aluno aluno;

}
