package com.jeictechnology.foro.dto.respuesta;

import com.jeictechnology.foro.domain.respuesta.Respuesta;
import com.jeictechnology.foro.dto.topico.DatosTopicoResponse;
import com.jeictechnology.foro.dto.usuario.DatosUsuario;

import java.time.LocalDateTime;

public record DatosRespuesta(
        String mensaje,
        LocalDateTime fecha,
        String autor
) {
    public DatosRespuesta(Respuesta respuesta){
        this(
                respuesta.getMensaje(),
                respuesta.getFecha(),
                respuesta.getAutor() != null ? respuesta.getAutor().getNombre() : null
        );
    }

}
