package com.example.demo.gateways;

import com.example.demo.domains.Materia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateriaRepository extends JpaRepository<Materia, String> {
}
