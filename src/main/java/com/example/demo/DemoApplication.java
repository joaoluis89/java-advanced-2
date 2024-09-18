package com.example.demo;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.AlunoRepository;
import java.time.LocalDate;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

	private final AlunoRepository alunoRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@EventListener(value = ApplicationReadyEvent.class)
	public void setupAlunos() {
		LocalDate now = LocalDate.now();
		for (int i = 0; i <= 200; i++) {
			if (i % 10 == 0) {
				now = now.plusDays(1);
			}
			Aluno alunoASerCadastrado = Aluno.builder()
				.pessoa(Pessoa.builder()
					.primeiroNome("Aluno ")
					.sobrenome("" + i)
					.build())
				.dataDaMatricula(now)
				.apelido("" + i)
				.build();
			alunoRepository.save(alunoASerCadastrado);
		}

	}

}
