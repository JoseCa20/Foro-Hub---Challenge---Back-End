package com.jeictechnology.foro.dto.topico;

import com.jeictechnology.foro.domain.curso.Curso;
import com.jeictechnology.foro.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record RegistrarTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        Integer status,
        @NotNull
        Long autor,
        @NotNull
        Long curso
) {
}
