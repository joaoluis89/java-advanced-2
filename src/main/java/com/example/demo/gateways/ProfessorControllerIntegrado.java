package com.example.demo.gateways;

import com.example.demo.gateways.requests.ProfessorRequestDtoPost;
import com.example.demo.gateways.responses.ProfessorResponseDtoPost;
import org.springframework.http.ResponseEntity;

public interface ProfessorControllerIntegrado {


    ResponseEntity<ProfessorResponseDtoPost> criaProfessor(ProfessorRequestDtoPost professorRequestDtoPost);
    /*
    Crie assinaturas que contemplem as seguintes operações
            criar um professor
            nome e materia devem ser não vazios
            copie os dados de entrada para os dados de saida
            rota: /fiap/professor
     */
}
