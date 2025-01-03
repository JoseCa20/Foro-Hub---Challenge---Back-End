package com.jeictechnology.foro.dto.topico;

import com.jeictechnology.foro.domain.topico.Topico;
import com.jeictechnology.foro.dto.respuesta.DatosRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosTopicoResponse(
         String titulo,
         String mensaje,
         LocalDateTime fecha,
         Integer status,
         String autor,
         String curso,
         List<DatosRespuesta> respuestas
) {
    public DatosTopicoResponse(Topico topico){
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFecha(),
                topico.getStatus(),
                topico.getAutor() != null ? topico.getAutor().getNombre() : null,
                topico.getCurso() != null ? topico.getCurso().getNombre() : null,
                topico.getRespuestas().stream()
                        .map(DatosRespuesta::new)
                        .toList()
        );
    }
}
