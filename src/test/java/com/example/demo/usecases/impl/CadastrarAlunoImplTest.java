package com.example.demo.usecases.impl;

import com.example.demo.domains.Aluno;
import com.example.demo.usecases.CadastrarAluno;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CadastrarAlunoImplTest {

  CadastrarAluno cadastrarAluno = new CadastrarAlunoImpl(null);

  @Test
  @DisplayName("Testa se as infos do objeto alunoASerCadastrado foram devidamente copiadas para un novo objeto")
  void testExecutaDeCadastrarAlunoParaIf(){
    //Dado uma condicao, Arrange, Expected
    Aluno alunoASerCadastrado = new Aluno();
    alunoASerCadastrado.setPrimeiroNome("Joao");
    alunoASerCadastrado.setSobrenome("Veronezzi");

    //QUando algo acontecer, Act, Actual
    Aluno cadastrado = cadastrarAluno.executa(alunoASerCadastrado);

    //Entao verifique uma determinada info, Assert
    Assertions.assertEquals(alunoASerCadastrado.getPrimeiroNome(), cadastrado.getPrimeiroNome(), "Deve copiar o primeiro nome de um objeto aluno para outro objeto aluno");
    Assertions.assertEquals(alunoASerCadastrado.getSobrenome(), cadastrado.getSobrenome(), "Deve copiar o sobrenome de um objeto aluno para outro objeto aluno ");

  }

  @Test
  void testExecutaDeCadastrarAlunoParaElse(){
    //Dado uma condicao, Arrange, Expected
    Aluno alunoASerCadastrado = new Aluno();
    alunoASerCadastrado.setPrimeiroNome("Maria Beatriz");
    alunoASerCadastrado.setSobrenome("Fogolin");

    //QUando algo acontecer, Act, Actual
    Aluno cadastrado = cadastrarAluno.executa(alunoASerCadastrado);

    //Entao verifique uma determinada info, Assert
    Assertions.assertEquals(alunoASerCadastrado.getPrimeiroNome(), cadastrado.getPrimeiroNome(), "Deve copiar o primeiro nome de um objeto aluno para outro objeto aluno");
    Assertions.assertEquals(alunoASerCadastrado.getSobrenome(), cadastrado.getSobrenome(), "Deve copiar o sobrenome de um objeto aluno para outro objeto aluno ");

  }

}