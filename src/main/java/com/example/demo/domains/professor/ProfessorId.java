package com.example.demo.domains.professor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;


@Data
@Embeddable
public class ProfessorId {

    private String materia;
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

}
