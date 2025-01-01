package com.jeictechnology.foro.controller;

import com.jeictechnology.foro.domain.curso.Curso;
import com.jeictechnology.foro.dto.curso.DatosCurso;
import com.jeictechnology.foro.service.CursoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    public CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @PostMapping
    public ResponseEntity<DatosCurso> registrarCurso(@RequestBody @Valid DatosCurso datosCurso) {
        DatosCurso nuevoCurso = cursoService.save(datosCurso);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCurso);
    }

}
