package com.example.demo;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.AuditableData;
import com.example.demo.domains.ContextoDeCadeia;
import com.example.demo.domains.Materia;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.AlunoRepository;
import com.example.demo.gateways.MateriaRepository;
import com.example.demo.gateways.clients.IbgeLocalidadesClient;
import com.example.demo.gateways.clients.response.EstadoResponse;
import com.example.demo.gateways.clients.response.MunicipioResponse;
import com.example.demo.gateways.requests.AlunoPostRequest;
import com.example.demo.usecases.CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
@EnableFeignClients
public class DemoApplication {

	private final AlunoRepository alunoRepository;
	private final MateriaRepository materiaRepository;
	private final IbgeLocalidadesClient ibgeLocalidadesClient;
	private final CadeiaDeResponsabilidadeDeValidacaoDoAlunoPostRequest validacaoDoAlunoPostRequest;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@EventListener(value = ApplicationReadyEvent.class)
	public void setupAlunos() {
		List<EstadoResponse> allEstados = ibgeLocalidadesClient.getAllEstados();
		List<MunicipioResponse> municipioPorEstado = ibgeLocalidadesClient.getAllMunicipiosPorEstado("11");
		LocalDate now = LocalDate.now();
		List<Materia> materias = new ArrayList<>();


		AlunoPostRequest alunoPostRequest = new AlunoPostRequest("Joao PAcheco", "8929282", "asderw8r29hud");
		ContextoDeCadeia contextoDeCadeia = ContextoDeCadeia.builder()
			.alunoPostRequest(alunoPostRequest)
			.build();

		ContextoDeCadeia comAprovacoes = validacaoDoAlunoPostRequest.handle(contextoDeCadeia);


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

