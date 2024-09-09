package com.example.demo.gateways;

import org.springframework.http.ResponseEntity;



public interface ProfessorController {

    //rota /fiap/professor/{id}
    //o body de retorno deve conter professorId
    ResponseEntity getUmProfessor(String professorId);

    //rota /fiap/professor
    //retorne uma lista vazia
    ResponseEntity getTodosOsProfessores();

    //rota /fiap/professor/{id}
    //retorne o status code mais adequado para a operação
    ResponseEntity deletaUmProfessor(String professorId);

    /*
    Crie assinaturas que contemplem as seguintes operações

        atualizar um professor por completo
            copie os dados de entrada mais o id para os dados de saida
            nome e materia devem ser não vazios
            rota: /fiap/professor/{id}

        atualizar parcialmente um professor
            deve atualizar somente materia
            rota: /fiap/professor/{id}/materia
    */





}
