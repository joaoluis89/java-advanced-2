package com.example.demo.usecases;

import com.example.demo.domains.ContextoDeCadeia;
import com.example.demo.gateways.requests.AlunoPostRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class EloValidaRegistroDoAlunoPostRequest implements EloValidadorDoAlunoPostRequest {
    @Override
    public ContextoDeCadeia handle(ContextoDeCadeia chainContext) {
        AlunoPostRequest alunoPostRequest = chainContext.getAlunoPostRequest();
        boolean isNumeric = StringUtils.isNumeric(alunoPostRequest.registro());
        chainContext.addApproval(this.getClass(), isNumeric ? "registroValidado" : "registroNaoNumerico", isNumeric);
        return chainContext;
    }
}
