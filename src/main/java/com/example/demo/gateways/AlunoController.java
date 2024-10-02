package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Materia;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.requests.AlunoPatchNome;
import com.example.demo.gateways.requests.AlunoPostRequest;
import com.example.demo.gateways.responses.AlunoResponse;
import com.example.demo.usecases.CadastrarAluno;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
@RequestMapping("/aluno/fiap2")
@RequiredArgsConstructor
@Validated
public class AlunoController {

    private final CadastrarAluno cadastrarAluno;
    private final AlunoRepository alunoRepository;
    private final MateriaRepository materiaRepository;
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

    @PostMapping
    public ResponseEntity<AlunoResponse> postAluno(@RequestBody @Valid AlunoPostRequest aluno) {
        String[] nomeSplitado = aluno.nomeCompleto().split(" ");

        Aluno alunoASerCadastrado = Aluno.builder()
            .pessoa(Pessoa.builder()
                .primeiroNome(nomeSplitado[0])
                .sobrenome(nomeSplitado[1])
                .build())
            .dataDaMatricula(LocalDate.now())
            .build();
        Aluno alunoCadastrado = cadastrarAluno.executa(alunoASerCadastrado);

        AlunoResponse alunoResponse = AlunoResponse.builder()
            .primeiroNome(alunoCadastrado.getPessoa().getPrimeiroNome())
            .sobrenome(alunoCadastrado.getPessoa().getSobrenome())
            .documento(alunoCadastrado.getPessoa().getDocumento())
            .registro(String.valueOf(alunoCadastrado.getRegistro()))
            .build();

        Link link = WebMvcLinkBuilder.linkTo(AlunoController.class).slash(alunoCadastrado.getRegistro()).withSelfRel();
        alunoResponse.add(link);
        return ResponseEntity.ok(alunoResponse);
    }

//  @PostMapping
//  @ResponseStatus(HttpStatus.CREATED)
//  public Aluno postAluno(@RequestBody @Valid AlunoPostRequest aluno) {
//    String[] nomeSplitado = aluno.nomeCompleto().split(" ");
//
//    Aluno alunoASerCadastrado = Aluno.builder()
//        .pessoa(Pessoa.builder()
//            .primeiroNome(nomeSplitado[0])
//            .sobrenome(nomeSplitado[1])
//            .build())
//        .dataDaMatricula(LocalDate.now())
//        .build();
//    Aluno alunoCadastrado = cadastrarAluno.executa(alunoASerCadastrado);
//    alunoCadastrado.add(Link.of("http://localhost:8080/aluno/fiap/" + alunoCadastrado.getRegistro()));
//
//    return alunoCadastrado;
//  }


    @PatchMapping("/{alunoId}/nome")
    public ResponseEntity<AlunoPatchNome> atualizaNome(@PathVariable String alunoId, @RequestBody @Valid
    AlunoPatchNome nome) {
        return ResponseEntity.ok(nome);
    }


    @GetMapping("/{alunoId}")
    public Optional<AlunoResponse> getAluno(@PathVariable String alunoId) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);
        Aluno aluno1 = optionalAluno.get();
        aluno1.getMaterias().forEach(materia -> {
            Link link =
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(AlunoController.class).getMateria(materia.getId()))
                    .withSelfRel();
            materia.add(link);
        });

        return optionalAluno.map(aluno -> AlunoResponse.builder()
            .primeiroNome(aluno.getPessoa().getPrimeiroNome())
            .sobrenome(aluno.getPessoa().getSobrenome())
            .documento(aluno.getPessoa().getDocumento())
            .registro(String.valueOf(aluno.getRegistro()))
            .materiaList(aluno1.getMaterias())
            .build());
    }

    @GetMapping("/materia/{materiaId}")
    public Materia getMateria(@PathVariable String materiaId) {
        return materiaRepository.findById(materiaId).get();
    }

    @GetMapping("/apelido/{apelido}")
    public ResponseEntity<String> getAlunoPorApelido(@PathVariable String apelido) {
        Optional<Aluno> optionalAluno = alunoRepository.findAlunoByApelido(apelido);


        return ResponseEntity.ok("Hello World");
    }

    @GetMapping("/materia-preferida")
    public ResponseEntity<Page<Aluno>> getAlunoPorMateria(@RequestParam String materia, @RequestParam Integer page,
                                                          @RequestParam(required = false, defaultValue = "DESC")
                                                          Sort.Direction sortingType) {

        PageRequest pageRequest = PageRequest.of(page, 21, Sort.by(sortingType, "pessoa.sobrenome").descending());
        Page<Aluno> alunosByMateriaPreferida = alunoRepository.findAlunosByMateriaPreferida(materia, pageRequest);

        return ResponseEntity.ok(alunosByMateriaPreferida);
    }

}
