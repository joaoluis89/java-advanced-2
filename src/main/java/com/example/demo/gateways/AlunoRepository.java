package com.example.demo.gateways;

import com.example.demo.domains.Aluno;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, UUID> {

}
