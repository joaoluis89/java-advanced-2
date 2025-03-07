package com.example.demo.usecases;

import com.example.demo.domains.ContextoDeCadeia;
import com.example.demo.gateways.requests.AlunoPostRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

@Service
public class ValidaNomeCompletoNaoVazioAlunoPostRequestElo implements EloValidadorDoAlunoPostRequest {
    @Override
    public ContextoDeCadeia handle(ContextoDeCadeia chainContext) {
        AlunoPostRequest alunoPostRequest = chainContext.getAlunoPostRequest();
        boolean isApproved = Strings.isNotEmpty(alunoPostRequest.nomeCompleto());
        if (isApproved) {
            chainContext.addApproval(this.getClass(), "nomeValidado", isApproved);

        } else {
            chainContext.addApproval(this.getClass(), "nomeNaoValidado", isApproved);
        }
        return chainContext;
    }
}
