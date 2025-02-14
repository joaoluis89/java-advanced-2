package com.example.demo.gateways.mvc;

import com.example.demo.domains.Aluno;
import com.example.demo.gateways.AlunoRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/view/aluno")
@RequiredArgsConstructor
public class MVCAlunoController {

    private final AlunoRepository alunoRepository;

    @GetMapping
    public ModelAndView getAllAlunos(
        @RequestParam(defaultValue = "10") int pageSize,
        @RequestParam(defaultValue = "0") int pageNumber,
        @RequestParam(defaultValue = "ASC") Sort.Direction sortingType
                                     ) {
        Page<Aluno> all = alunoRepository.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(sortingType, "pessoa.sobrenome").descending()));
        List<Aluno> alunos = all.getContent();
        return new ModelAndView("alunos-page", "alunos", alunos);
    }
}
