package com.jeictechnology.foro.dto.curso;

import jakarta.validation.constraints.NotBlank;

public record DatosCurso(
        @NotBlank
        String nombre,
        @NotBlank
        String categoria
) {
}