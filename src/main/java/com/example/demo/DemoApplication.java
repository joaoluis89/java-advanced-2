package com.example.demo;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.AuditableData;
import com.example.demo.domains.Materia;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.AlunoRepository;
import com.example.demo.gateways.MateriaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class DemoApplication {

	private final AlunoRepository alunoRepository;
	private final MateriaRepository materiaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@EventListener(value = ApplicationReadyEvent.class)
	public void setupAlunos() {
		LocalDate now = LocalDate.now();
		List<Materia> materias = new ArrayList<>();
		for (int i = 0; i <= 10; i++) {
			Materia build = Materia.builder()
				.nome("Materia " + i)
				.build();
			Materia saved = materiaRepository.save(build);
			materias.add(saved);
		}
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
				.materiaPreferida("JavaAdvanced")
				.materias(materias)
				.auditableData(new AuditableData())
				.build();
			alunoRepository.save(alunoASerCadastrado);
		}

	}

}
