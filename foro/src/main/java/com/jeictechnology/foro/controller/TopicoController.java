package com.jeictechnology.foro.controller;

import com.jeictechnology.foro.domain.topico.Topico;
import com.jeictechnology.foro.dto.topico.DatosTopicoResponse;
import com.jeictechnology.foro.dto.topico.RegistrarTopico;
import com.jeictechnology.foro.service.CursoService;
import com.jeictechnology.foro.service.TopicoService;
import com.jeictechnology.foro.service.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService, UsuarioService usuarioService, CursoService cursoService) {
        this.topicoService = topicoService;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosTopicoResponse> crearTopico(@RequestBody @Valid RegistrarTopico registrarTopico) {
        System.out.println(registrarTopico);
        DatosTopicoResponse topicoCreado = topicoService.crearTopico(registrarTopico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicoCreado);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopicoResponse>> listarTopicosPorFecha(@PageableDefault(size = 2) Pageable paginacion) {
        //Esta línea solo muestra tópicos activos
        return ResponseEntity.ok(topicoService.obtenerTopicosOrdenadosFecha(paginacion).map(DatosTopicoResponse::new));
    }

    @GetMapping(path = "/buscar")
    public ResponseEntity<Page<Topico>> listarTopicoPorAnioOCurso(
            @RequestParam(required = false) Integer anio,
            @RequestParam(required = false) String cursoNombre,
            @PageableDefault() Pageable paginacion) {

        if (anio != null && cursoNombre != null) {
            return ResponseEntity.ok((Page<Topico>) topicoService.obtenerTopicoPorAnioOCurso(anio, cursoNombre, paginacion));
        } else if (anio != null) {
            return ResponseEntity.ok((Page<Topico>) topicoService.obtenerTopicoPorAnio(anio, paginacion));
        } else if (cursoNombre != null) {
            return ResponseEntity.ok((Page<Topico>) topicoService.obtenerTopicoPorNombreCurso(cursoNombre, paginacion));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
