package com.example.demo.gateways;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.afford;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.example.demo.domains.Aluno;
import com.example.demo.domains.Materia;
import com.example.demo.domains.Pessoa;
import com.example.demo.gateways.requests.AlunoPatchNome;
import com.example.demo.gateways.requests.AlunoPostRequest;
import com.example.demo.gateways.responses.AlunoResponse;
import com.example.demo.gateways.responses.MateriaResponse;
import com.example.demo.usecases.CadastrarAluno;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
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
@Slf4j
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
//    @GetMapping("/{salaId}/{alunoId}/nome")
//    @ResponseStatus(HttpStatus.OK)
//    public Aluno getAluno(@PathVariable String alunoId, @PathVariable String salaId) {
//        return new Aluno();
//    }

    @PostMapping
    public ResponseEntity<AlunoResponse> postAluno(Authentication authentication, @RequestBody @Valid AlunoPostRequest aluno) {
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

        Link link = linkTo(AlunoController.class).slash(alunoCadastrado.getRegistro()).withSelfRel();
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

    @Operation(summary = "Atualiza o nome do aluno", description = "Recebe dois parametros que depois serao convertidos blablablabla")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", links = {
            @io.swagger.v3.oas.annotations.links.Link(name = "teste", operationRef = "GET")
        }),
        @ApiResponse(responseCode = "404")
    })
    @PatchMapping("/{alunoId}/nome")
    public AlunoResponse atualizaNome(
        @PathVariable String alunoId,
        @RequestParam(required = false, defaultValue = "10") Integer idade,
        @RequestBody @Valid AlunoPatchNome nome) {
        log.debug("Log passei por aqui DEBUG {} {}", alunoId, idade);
        log.info("Log passei por aqui INFO {} {}", alunoId, idade);
        log.error("Log passei por aqui ERROR {} {}", alunoId, idade);

        //trace
        //debug
        //info
        //warn
        //erro

        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);


        return optionalAluno.map(aluno -> {
            aluno.getPessoa().setPrimeiroNome(nome.getPrimeiroNome());
            return alunoRepository.save(aluno);

        }).map(this::getAlunoResponse).orElse(null);

    }


    @GetMapping("/{alunoId}")
    public AlunoResponse getAluno(Authentication authentication,  @PathVariable String alunoId) {
        Optional<Aluno> optionalAluno = alunoRepository.findById(alunoId);

        return optionalAluno.map(this::getAlunoResponse).orElse(null);
    }

    private AlunoResponse getAlunoResponse(Aluno aluno) {
        return AlunoResponse.builder()
            .primeiroNome(aluno.getPessoa().getPrimeiroNome())
            .sobrenome(aluno.getPessoa().getSobrenome())
            .documento(aluno.getPessoa().getDocumento())
            .registro(String.valueOf(aluno.getRegistro()))
            .materiaList(aluno.getMaterias().stream().map(this::materiaToResponse).toList())
            .build()
            .add(
                linkTo(AlunoController.class,
                    methodOn(AlunoController.class)
                        .getAluno(null, aluno.getRegistro())
                ).withSelfRel()
                    .andAffordance(
                        afford(methodOn(AlunoController.class)
                            .atualizaNome(aluno.getRegistro(), 0, new AlunoPatchNome()))
                    )
            );
    }

    private MateriaResponse materiaToResponse(Materia materia) {
        return MateriaResponse.builder()
            .descricao(materia.getNome())
            .build()
            .add(linkTo(
                    methodOn(AlunoController.class)
                        .getMateria(materia.getId())
                ).withSelfRel()
            );
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
