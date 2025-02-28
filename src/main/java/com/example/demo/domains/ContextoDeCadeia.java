package com.example.demo.domains;

import com.example.demo.gateways.requests.AlunoPostRequest;
import com.example.demo.usecases.ValidadorDoAlunoPostRequest;
import java.util.Stack;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.apache.commons.lang3.tuple.Triple;

@Builder
@Getter
@ToString
public class ContextoDeCadeia {

    AlunoPostRequest alunoPostRequest;
    @Builder.Default
    Stack<Triple<Class<? extends ValidadorDoAlunoPostRequest>, String, Boolean>> aprovacoes = new Stack<>();


    public void addApproval(
        Class<? extends ValidadorDoAlunoPostRequest> classeAprovadora,
        String mensagem,
        Boolean aprovacao) {
        this.aprovacoes.push(Triple.of(classeAprovadora, mensagem, aprovacao));
    }
}
