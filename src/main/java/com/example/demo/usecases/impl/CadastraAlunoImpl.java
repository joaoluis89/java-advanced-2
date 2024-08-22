package com.example.demo.usecases.impl;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.AlunoRepository;
import com.example.demo.usecases.CadastraAluno;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadastraAlunoImpl implements CadastraAluno {

  private final AlunoRepository alunoRepository;
  @Override
  public Aluno executa(Aluno alunoParaSerCadastrar) {

    Pessoa pessoa = new Pessoa();
    Aluno cadastrado = new Aluno();
    cadastrado.setPrimeiroNome(alunoParaSerCadastrar.getPrimeiroNome());
    cadastrado.setSobrenome(alunoParaSerCadastrar.getSobrenome());
    return cadastrado;
  }

  public void helloWorld() {

  }
}
