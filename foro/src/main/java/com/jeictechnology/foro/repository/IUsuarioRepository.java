package com.jeictechnology.foro.repository;

import com.jeictechnology.foro.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
}
