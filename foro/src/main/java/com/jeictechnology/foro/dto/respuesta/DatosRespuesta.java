package com.jeictechnology.foro.dto.respuesta;

import com.jeictechnology.foro.dto.topico.DatosTopicoResponse;
import com.jeictechnology.foro.dto.usuario.DatosUsuario;

import java.time.LocalDateTime;

public record DatosRespuesta(
        String mensaje,
        LocalDateTime fechaRespuesta,
        String autor
) {

}
