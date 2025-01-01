package com.jeictechnology.foro.controller;

import com.jeictechnology.foro.domain.usuario.Usuario;
import com.jeictechnology.foro.dto.usuario.DatosUsuario;
import com.jeictechnology.foro.dto.usuario.DatosUsuarioRespuesta;
import com.jeictechnology.foro.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;


    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<DatosUsuarioRespuesta> crearUsuario(@RequestBody @Valid DatosUsuario datosUsuario){
        DatosUsuarioRespuesta nuevoUsuario = usuarioService.crearUsuario(datosUsuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoUsuario);
    }
}
