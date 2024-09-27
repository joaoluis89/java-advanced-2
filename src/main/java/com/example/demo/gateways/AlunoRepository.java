package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, String> {


    Optional<Aluno> findAlunoByApelido(String apelido);

    Page<Aluno> findAlunosByMateriaPreferida(String materiaPreferida, Pageable pageable);

    List<Aluno> findAlunosByMateriaPreferidaAndApelido(String materia, String apelido);

    List<Aluno> findAlunosByDataDaMatriculaGreaterThanEqual(LocalDate date);

    List<Aluno> findAlunoByPessoaPrimeiroNomeContains(String nome);

}
