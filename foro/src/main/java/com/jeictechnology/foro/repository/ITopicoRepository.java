package com.jeictechnology.foro.repository;

import com.jeictechnology.foro.domain.topico.Topico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ITopicoRepository extends JpaRepository<Topico, Long> {

    Page<Topico> findByStatus(Integer status, Pageable paginacion);

    Page<Topico> findAll(Pageable paginacion);

    Page<Topico> findByStatusOrderByFechaAsc(Integer status, Pageable paginacion);

    @Query("Select t from Topico t where function('year', t.fecha) = :anio")
    Page<Topico> findByAnio(@Param("anio") Integer anio, Pageable paginacion);

    @Query("select t from Topico t where t.curso.nombre = :nombreCurso")
    Page<Topico> findByCurso(@Param("nombreCurso") String nombreCurso, Pageable paginacion);

    @Query("SELECT t FROM Topico t WHERE YEAR(t.fecha) = :anio AND t.curso.nombre = :curso")
    List<Topico> findByAnioAndCurso(@Param("anio") Integer anio, @Param("curso") String curso, Pageable paginacion);

}
