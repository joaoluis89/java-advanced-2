package com.example.demo.gateways.responses;

import lombok.Builder;
import lombok.Data;


/**
 * A classe {@code AlunoResponse} representa uma resposta que contém informações sobre um aluno.
 *
 * <h2>Anotações Utilizadas:</h2>
 *
 * <ul>
 *   <li>{@code @Data} - Esta anotação é uma combinação de várias anotações do Lombok.
 *       Ela automaticamente gera os métodos getter e setter para todos os campos da classe,
 *       bem como implementações dos métodos {@code toString()}, {@code equals(Object other)},
 *       e {@code hashCode()}. Isso é extremamente útil para classes que armazenam dados,
 *       pois reduz o boilerplate relacionado a acessar e modificar os campos.</li>
 *   <li>{@code @Builder} - Esta anotação permite a implementação do padrão de projeto Builder
 *       para a classe. Com o Builder, você pode criar instâncias de {@code AlunoResponse} de
 *       maneira flexível e legível, especialmente útil quando há muitos campos ou quando alguns
 *       campos podem ser opcionais. O Builder gera um método estático {@code builder()} que
 *       permite a construção de objetos AlunoResponse por meio de uma API fluente.</li>
 * </ul>
 *
 * <p>A classe {@code AlunoResponse} contém campos que representam os detalhes básicos de um aluno:</p>
 * <ul>
 *   <li>{@code primeiroNome} - O primeiro nome do aluno.</li>
 *   <li>{@code sobrenome} - O sobrenome do aluno.</li>
 *   <li>{@code documento} - O documento de identidade do aluno.</li>
 *   <li>{@code registro} - O registro acadêmico do aluno.</li>
 * </ul>
 *
 * <p>Utilizar {@code @Builder} juntamente com {@code @Data} proporciona um método eficiente e
 * legível para criar e manipular instâncias de classes de dados como {@code AlunoResponse}.</p>
 *
 * <p>Exemplo de uso do Builder:</p>
 * <pre>
 * AlunoResponse aluno = AlunoResponse.builder()
 *      .primeiroNome("João")
 *      .sobrenome("Silva")
 *      .documento("123456789")
 *      .registro("20230001")
 *      .build();
 * </pre>
 */

@Builder
@Data
public class AlunoResponse {

  private String primeiroNome;
  private String sobrenome;
  private String documento;
  private String registro;
}
