package com.example.demo.domains;

import com.example.demo.domains.professor.Professor;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.hateoas.RepresentationModel;


/**
 * A classe {@code Aluno} representa um estudante e é uma subclasse de {@code Pessoa}.
 *
 * <p>Esta classe utiliza anotações da biblioteca Lombok para reduzir o código boilerplate,
 * como construtores, getters/setters, e métodos utilitários como {@code toString()},
 * {@code equals()}, e {@code hashCode()}.</p>
 *
 * <h2>Anotações Utilizadas:</h2>
 *
 * <ul>
 *   <li>{@code @Data} - Esta anotação é uma combinação de várias anotações do Lombok.
 *       Ela automaticamente gera os métodos getter e setter para todos os campos,
 *       bem como {@code toString()}, {@code equals(Object other)} e {@code hashCode()}.</li>
 *   <li>{@code @AllArgsConstructor} - Gera um construtor que aceita um argumento para cada campo da classe.
 *       Este construtor pode ser útil para criar instâncias completas do objeto diretamente com todos os valores,
 *       sem precisar setá-los após a criação.</li>
 *   <li>{@code @NoArgsConstructor} - Gera um construtor sem argumentos. Isso permite a criação de uma instância
 *       do objeto sem definir imediatamente seus valores. Pode ser útil em frameworks que requerem um construtor padrão.</li>
 * </ul>
 *
 * <p>
 * A classe herda da classe {@code Pessoa}, usando um construtor adicional que aceita
 * os parâmetros necessários para inicializar tanto os campos da classe pai quanto da classe {@code Aluno}.</p>
 *
 * @see Pessoa
 */


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends RepresentationModel<Aluno> {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String registro;

  private String apelido;

  private String materiaPreferida;

  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
  private Pessoa pessoa;

  @ManyToOne
  private Professor professor;

  @ManyToMany
  private List<Materia> materias;

  private LocalDate dataDaMatricula;

  private AuditableData auditableData;
}
