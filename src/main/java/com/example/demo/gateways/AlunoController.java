package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.requests.AlunoPatchNome;
import com.example.demo.gateways.requests.AlunoPostRequest;
import com.example.demo.gateways.responses.AlunoResponse;
import com.example.demo.usecases.CadastrarAluno;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controllers são pontos de entrada da aplicação. Eles são responsáveis por expor os endpoints que ficaram disponiveis para uso <p>
 * {@link RestController RestController} indica ao spring que deve expor os metodos publicos anotados com XXXMapping para os devidos endpoints e seus verbos
 * {@link RequestMapping RequestMapping} indica que há uma caminho padrão a ser aplicado antes de cada endponit, ex: <p>
 * Classe com RequestMapping(/aluno) <p>
 * Método com GetMapping(/fiap)<p>
 * o endpoint exposto final para esse conjunto será: "/aluno/fiap" <p>
 *
 * @see RestController
 * @see RequestMapping
 * @see GetMapping
 * @see PutMapping
 * @see PostMapping
 * @see PatchMapping
 * @see org.springframework.web.bind.annotation.DeleteMapping
 */

@RestController
@RequestMapping("/aluno/fiap")
@RequiredArgsConstructor
@Validated
public class AlunoController {

  private final CadastrarAluno cadastrarAluno;
  //localhost:8080/aluno/fiap?sala=2tds
  //localhost:8080/aluno/fiap/sala

  /**
   * {@link ResponseEntity} é um retorno que dá mais liberdade para manipular os status code que podemos entregar na API
   */
  @GetMapping
  public ResponseEntity<String> getAlunos(@RequestParam(required = false) List<String> sala) {
    return ResponseEntity.ok("Hello World");
  }

  /**
   * Também podemos retornar o propiro objeto sem fazer uso de ResponseEntity, porem perdemos a habilidade de manipular explicitamente o status code <p>
   * Assim fazemos uso do {@link ResponseStatus} para deixar claro qual o status de sucesso deve ser exposto
   */
  @GetMapping("/{salaId}/{alunoId}/nome")
  @ResponseStatus(HttpStatus.OK)
  public Aluno getAluno(@PathVariable String alunoId, @PathVariable String salaId) {
    return new Aluno();
  }

  @PostMapping("/{salaId}")
  public ResponseEntity<AlunoResponse> postAluno(@RequestBody @Valid AlunoPostRequest aluno) {
    String[] nomeSplitado = aluno.nomeCompleto().split(" ");

    Aluno alunoASerCadastrado = Aluno.builder()
        .pessoa(Pessoa.builder()
            .primeiroNome(nomeSplitado[0])
            .sobrenome(nomeSplitado[1])
            .build())
        .build();
    Aluno alunoCadastrado = cadastrarAluno.executa(alunoASerCadastrado);

    AlunoResponse alunoResponse = AlunoResponse.builder()
        .primeiroNome(alunoCadastrado.getPessoa().getPrimeiroNome())
        .sobrenome(alunoCadastrado.getPessoa().getSobrenome())
        .documento(alunoCadastrado.getPessoa().getDocumento())
        .registro(String.valueOf(alunoCadastrado.getRegistro()))
        .build();
    return ResponseEntity.ok(alunoResponse);
  }


  @PatchMapping("/{alunoId}/nome")
  public ResponseEntity<AlunoPatchNome> atualizaNome(@PathVariable String alunoId, @RequestBody @Valid
  AlunoPatchNome nome) {
    return ResponseEntity.ok(nome);
  }
}
