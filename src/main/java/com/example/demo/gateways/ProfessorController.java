package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Professor;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/professor/fiap")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorRepository professorRepository;
    private final AlunoRepository alunoRepository;

    @PostMapping
    public Professor criaProfessor(@RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PatchMapping("/{professorId}/alunos")
    public Optional<Professor> associaAlunos(@PathVariable UUID professorId, @RequestBody List<UUID> listaDeIdsDeAlunos) {
        List<Aluno> allById = alunoRepository.findAllById(listaDeIdsDeAlunos);
        Optional<Professor> professor = professorRepository.findById(professorId.toString());
        professor.ifPresent(professor1 -> {
            professor1.setAlunos(allById);
            professorRepository.save(professor1);
        });

        return professor;
    }
}
