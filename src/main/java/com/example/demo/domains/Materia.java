package com.example.demo.domains;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
public class Materia extends RepresentationModel<Materia> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String nome;

    @ManyToMany(mappedBy = "materias", fetch = FetchType.LAZY)
    List<Aluno> alunos;
}
