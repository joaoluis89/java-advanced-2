package com.example.demo.gateways;

import com.example.demo.domains.Usuario;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {


    Optional<Usuario> findByUsername(String username);
}
