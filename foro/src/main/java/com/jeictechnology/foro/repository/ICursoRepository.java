package com.jeictechnology.foro.repository;

import com.jeictechnology.foro.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICursoRepository extends JpaRepository<Curso, Long> {
}
