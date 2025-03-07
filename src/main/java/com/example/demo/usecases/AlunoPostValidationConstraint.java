package com.example.demo.usecases;

import com.example.demo.domains.ContextoDeCadeia;
import com.example.demo.gateways.requests.AlunoPostRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.tuple.Triple;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoPostValidationConstraint implements ConstraintValidator<AlunoPostRequestValidation, AlunoPostRequest> {

    private final CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest cadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest;

    @Override
    public boolean isValid(AlunoPostRequest value, ConstraintValidatorContext context) {
        ContextoDeCadeia handle =
            cadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest.handle(ContextoDeCadeia.builder()
                .alunoPostRequest(value)
                .build());
        return handle.getAprovacoes().stream().allMatch(Triple::getRight);
    }
}
