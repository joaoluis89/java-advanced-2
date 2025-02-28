package com.example.demo.usecases;


import com.example.demo.domains.ContextoDeCadeia;

public interface ValidadorDoAlunoPostRequest {

    ContextoDeCadeia handle(ContextoDeCadeia chainContext);
}
