package com.example.demo.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;

@Entity
@Getter
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @OneToOne
    private Usuario usuario;

    @ManyToOne
    private Turma turma;

    @OneToMany(mappedBy = "aluno")
    private List<Estuda> matriculas;

    private LocalDate dataDeAdmissao;

}
