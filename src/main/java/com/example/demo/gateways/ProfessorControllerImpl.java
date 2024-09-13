package com.example.demo.gateways;

import com.example.demo.domains.Professor;
import com.example.demo.gateways.requests.ProfessorRequestDtoPatch;
import com.example.demo.gateways.requests.ProfessorRequestDtoPost;
import com.example.demo.gateways.requests.ProfessorRequestDtoPut;
import com.example.demo.gateways.responses.ProfessorResponseDtoPatch;
import com.example.demo.gateways.responses.ProfessorResponseDtoPost;
import com.example.demo.gateways.responses.ProfessorResponseDtoPut;
import com.example.demo.usecases.SalvaProfessor;
import jakarta.validation.Valid;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/fiap/professor")
@RequiredArgsConstructor
public class ProfessorControllerImpl implements ProfessorController, ProfessorControllerIntegrado{


    private final SalvaProfessor salvaProfessor;

    @Override
    public ResponseEntity getUmProfessor(String professorId) {
        return null;
    }

    @Override
    public ResponseEntity getTodosOsProfessores() {
        return null;
    }

    @Override
    public ResponseEntity deletaUmProfessor(String professorId) {
        return null;
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<ProfessorResponseDtoPut> atualizaProfessorPorCompleto(
        @RequestBody @Valid ProfessorRequestDtoPut professorRequestDtoPut) {
        return null;
    }

    @Override
    public ResponseEntity<ProfessorResponseDtoPatch> atualizaMateriaProfessor(
        ProfessorRequestDtoPatch professorRequestDtoPatch) {
        return null;
    }

    @Override
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProfessorResponseDtoPost> criaProfessor(@RequestBody @Valid ProfessorRequestDtoPost professorRequestDtoPost) {

        Professor professor = Professor.builder()
            .materia(professorRequestDtoPost.getMateria())
            .nome(professorRequestDtoPost.getNome())
            .build();

        Professor professorSalvo = salvaProfessor.execute(professor);

        ProfessorResponseDtoPost resultado = ProfessorResponseDtoPost.builder()
            .materia(professorSalvo.getMateria())
            .nome(professorSalvo.getNome())
            .build();

        return ResponseEntity.of(Optional.of(resultado));
    }
}
