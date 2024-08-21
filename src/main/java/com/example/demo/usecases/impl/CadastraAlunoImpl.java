package com.example.demo.usecases.impl;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Pessoa;
import com.example.demo.usecases.CadastraAluno;

public class CadastraAlunoImpl implements CadastraAluno {

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
