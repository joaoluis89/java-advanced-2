package com.example.demo.usecases;

import com.example.demo.domains.Aluno;
import org.springframework.stereotype.Service;

@Service
public interface CadastrarAluno {

  Aluno executa(Aluno alunoParaSerCadastrar);
}
