package com.jeictechnology.foro.dto.usuario;

import com.jeictechnology.foro.domain.perfil.Perfil;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuario (
        @NotBlank
        String nombre,
        @NotBlank
        String email,
        @NotBlank
        String contrasena
){
}
