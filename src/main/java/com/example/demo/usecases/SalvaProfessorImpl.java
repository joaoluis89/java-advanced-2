package com.example.demo.usecases;

import com.example.demo.domains.Professor;
import com.example.demo.gateways.ProfessorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalvaProfessorImpl implements SalvaProfessor{

    private final ProfessorRepository professorRepository;

    //Outro meotodo para registro de bean é o @Service
    @Override
    public Professor execute(Professor professor) {
        return professorRepository.save(professor);
    }
}
