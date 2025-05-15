package com.aulas.testesunitarios.repository;

import com.aulas.testesunitarios.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
