package com.example.demo.gateways;

import com.example.demo.domains.professor.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, String> {
}
