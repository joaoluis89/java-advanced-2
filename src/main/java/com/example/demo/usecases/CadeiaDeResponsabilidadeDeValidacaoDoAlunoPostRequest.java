package com.example.demo.usecases;


import com.example.demo.domains.ContextoDeCadeia;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest {

    private final List<ValidadorDoAlunoPostRequest> validadorDoAlunoPostRequests;


    public ContextoDeCadeia handle(ContextoDeCadeia contextoDeCadeia) {

        ContextoDeCadeia temp = contextoDeCadeia;

        for(ValidadorDoAlunoPostRequest validadorDoAlunoPostRequest: validadorDoAlunoPostRequests) {
            temp = validadorDoAlunoPostRequest.handle(temp);
        }
        return temp;
    }
}
