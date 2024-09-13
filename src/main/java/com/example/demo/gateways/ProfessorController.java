package com.example.demo.gateways;

import com.example.demo.gateways.requests.ProfessorRequestDtoPatch;
import com.example.demo.gateways.requests.ProfessorRequestDtoPut;
import com.example.demo.gateways.responses.ProfessorResponseDtoPatch;
import com.example.demo.gateways.responses.ProfessorResponseDtoPut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public interface ProfessorController {

    //rota /fiap/professor/{id}
    //o body de retorno deve conter professorId
    @GetMapping("/fiap/professor/{id}")
    ResponseEntity getUmProfessor(String professorId);

    //rota /fiap/professor
    //retorne uma lista vazia
    ResponseEntity getTodosOsProfessores();

    //rota /fiap/professor/{id}
    //retorne o status code mais adequado para a operação
    ResponseEntity deletaUmProfessor(String professorId);



    ResponseEntity<ProfessorResponseDtoPut> atualizaProfessorPorCompleto(ProfessorRequestDtoPut professorRequestDtoPut);

    ResponseEntity<ProfessorResponseDtoPatch> atualizaMateriaProfessor(ProfessorRequestDtoPatch professorRequestDtoPatch);

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
