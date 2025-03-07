package com.example.demo.usecases;


import com.example.demo.domains.ContextoDeCadeia;

public interface EloValidadorDoAlunoPostRequest {

    ContextoDeCadeia handle(ContextoDeCadeia chainContext);
}
