package com.jeictechnology.foro.service;

import com.jeictechnology.foro.domain.curso.Curso;
import com.jeictechnology.foro.dto.curso.DatosCurso;
import com.jeictechnology.foro.repository.ICursoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class CursoService {

    private final ICursoRepository iCursoRepository;

    public CursoService(ICursoRepository iCursoRepository) {
        this.iCursoRepository = iCursoRepository;
    }

    public DatosCurso save(DatosCurso datosCurso){
        Curso curso = new Curso();
        curso.setNombre(datosCurso.nombre());
        curso.setCategoria(datosCurso.categoria());
        Curso cursoGuardado = iCursoRepository.save(curso);
        return new DatosCurso(cursoGuardado.getNombre(), cursoGuardado.getCategoria());
    }

    public Curso obtenerCursoById(Long id) {
        return iCursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("curso no encontrado"));
    }
}
