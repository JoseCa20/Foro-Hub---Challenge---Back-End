package com.jeictechnology.foro.controller;

import com.jeictechnology.foro.dto.topico.DatosTopicoResponse;
import com.jeictechnology.foro.dto.topico.RegistrarTopico;
import com.jeictechnology.foro.service.CursoService;
import com.jeictechnology.foro.service.TopicoService;
import com.jeictechnology.foro.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService, UsuarioService usuarioService, CursoService cursoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosTopicoResponse>crearTopico(@RequestBody @Valid RegistrarTopico registrarTopico){
        System.out.println(registrarTopico);
        DatosTopicoResponse topicoCreado = topicoService.crearTopico(registrarTopico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoCreado);
    }

}
