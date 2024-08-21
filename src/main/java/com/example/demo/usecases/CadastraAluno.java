package com.example.demo.usecases;

import com.example.demo.domains.Aluno;

public interface CadastraAluno {

  Aluno executa(Aluno alunoParaSerCadastrar);
}
