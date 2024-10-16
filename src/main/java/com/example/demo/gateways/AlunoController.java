package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import com.example.demo.gateways.responses.AlunoResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/aluno/fiap2")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final AlunoRepository alunoRepository;

    @GetMapping("/{alunoId}")
    public AlunoResponse getAluno(@PathVariable String alunoId) {
        return alunoRepository.findById(alunoId)
            .map(this::getAlunoResponse)
            .orElse(null);
    }

    private AlunoResponse getAlunoResponse(Aluno aluno) {
        return AlunoResponse.builder().build();
    }

}
