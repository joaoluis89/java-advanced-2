package com.example.demo.usecases.impl;

import com.example.demo.domains.Aluno;
import com.example.demo.gateways.AlunoRepository;
import com.example.demo.usecases.CadastrarAluno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastrarAlunoImpl implements CadastrarAluno {

  private final  AlunoRepository alunoRepository;

  @Override
  public Aluno executa(Aluno alunoParaSerCadastrado) {
    return alunoRepository.save(alunoParaSerCadastrado);
  }

  public void helloWorld() {

  }
}
