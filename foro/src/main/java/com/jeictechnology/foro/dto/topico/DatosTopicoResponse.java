package com.jeictechnology.foro.dto.topico;

import com.jeictechnology.foro.dto.respuesta.DatosRespuesta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopicoResponse(
         String titulo,
         String mensaje,
         LocalDateTime fechaCreacion,
         Integer status,
         String autor,
         String curso,
         List<DatosRespuesta> respuestas
) {
}
