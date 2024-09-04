package com.example.demo.gateways.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

/**
 * A classe {@code AlunoPostRequest} é um exemplo de record introduzido no Java 14 como uma prévia
 * e estabilizado no Java 16.
 *
 * <p>Um record em Java é uma forma concisa de definir uma classe que é utilizada principalmente para
 * armazenar dados simples. Records são imutáveis e fornecem automaticamente implementações para
 * os métodos {@code equals()}, {@code hashCode()}, e {@code toString()} com base em suas componentes,
 * que são os parâmetros definidos no record.</p>
 *
 * <p>Características principais de um record:</p>
 * <ul>
 *   <li>Imutabilidade: Os campos de um record são finais e suas instâncias são, portanto, imutáveis.</li>
 *   <li>Concisão: Define automaticamente um construtor, métodos de acesso (getters), e métodos
 *       {@code equals()}, {@code hashCode()}, e {@code toString()} baseados nos campos declarados.</li>
 *   <li>Utilização típica: Ideal para representar dados agregados de forma simples, como objetos de
 *       transporte de dados ou DTOs (Data Transfer Objects).</li>
 * </ul>
 *
 * A utilização de records reduz significativamente o código boilerplate necessário para classes
 * que são essencialmente "portadoras de dados", promovendo uma sintaxe mais limpa e organizada.
 *
 * <p>O {@code AlunoPostRequest} encapsula os detalhes necessários para criar uma requisição de
 * cadastro de aluno com os seguintes atributos:</p>
 * <ul>
 *   <li>{@code nomeCompleto} - O nome completo do aluno.</li>
 *   <li>{@code documento} - O documento de identidade do aluno.</li>
 *   <li>{@code registro} - O registro acadêmico do aluno.</li>
 * </ul>
 */

@Valid
public record AlunoPostRequest(
    String nomeCompleto,
    @NotNull String documento,
    String registro
    ) {

}
