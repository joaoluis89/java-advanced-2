package com.example.demo.domains.professor;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Pessoa;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Professor {

    @Id
    private ProfessorId professorId;


    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;

    @OneToMany(mappedBy = "professor")
    private List<Aluno> alunos;

}
