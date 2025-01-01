package com.jeictechnology.foro.repository;

import com.jeictechnology.foro.domain.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {
}
