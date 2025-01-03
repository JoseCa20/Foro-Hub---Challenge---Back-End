package com.jeictechnology.foro.service;

import com.jeictechnology.foro.domain.curso.Curso;
import com.jeictechnology.foro.domain.topico.Topico;
import com.jeictechnology.foro.domain.usuario.Usuario;
import com.jeictechnology.foro.dto.respuesta.DatosRespuesta;
import com.jeictechnology.foro.dto.topico.DatosTopicoResponse;
import com.jeictechnology.foro.dto.topico.RegistrarTopico;
import com.jeictechnology.foro.repository.ICursoRepository;
import com.jeictechnology.foro.repository.ITopicoRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.jeictechnology.foro.repository.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    private final ITopicoRepository iTopicoRepository;
    private final IUsuarioRepository iUsuarioRepository;
    private final ICursoRepository iCursoRepository;

    public TopicoService(ITopicoRepository iTopicoRepository,
                         IUsuarioRepository iUsuarioRepository,
                         ICursoRepository iCursoRepository) {
        this.iTopicoRepository = iTopicoRepository;
        this.iUsuarioRepository = iUsuarioRepository;
        this.iCursoRepository = iCursoRepository;
    }

    @Transactional
    public DatosTopicoResponse crearTopico(RegistrarTopico registrarTopico){

        Usuario autor = iUsuarioRepository.findById(registrarTopico.autor())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        Curso curso = iCursoRepository.findById(registrarTopico.curso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(registrarTopico.titulo());
        topico.setMensaje(registrarTopico.mensaje());
        topico.setFecha(LocalDateTime.now());
        topico.setStatus(registrarTopico.status());
        topico.setAutor(autor);
        topico.setCurso(curso);
        System.out.println(topico);
        Topico topicoGuardado = iTopicoRepository.save(topico);

        return new DatosTopicoResponse(
                topicoGuardado.getTitulo(),
                topicoGuardado.getMensaje(),
                topicoGuardado.getFecha(),
                topicoGuardado.getStatus(),
                topicoGuardado.getAutor().getNombre(),
                topicoGuardado.getCurso().getNombre(),
                topicoGuardado.getRespuestas().stream()
                        .map(r -> new DatosRespuesta(
                                r.getMensaje(),
                                r.getFecha(),
                                r.getAutor().getNombre()))
                        .collect(Collectors.toList())

        );
    }

    public Page<Topico> obtenerTopicosOrdenadosFecha(Pageable pageable){
        return iTopicoRepository.findByStatusOrderByFechaAsc(1, pageable);
    }

    public Page<Topico> obtenerTopicoPorAnio(Integer anio, Pageable pageable){
        return iTopicoRepository.findByAnio(anio, pageable);
    }

    public Page<Topico> obtenerTopicoPorNombreCurso(String cursoNombre, Pageable pageable){
        return iTopicoRepository.findByCurso(cursoNombre, pageable);
    }

    public List<Topico> obtenerTopicoPorAnioOCurso(Integer anio, String curso, Pageable pageable){
        return  iTopicoRepository.findByAnioAndCurso(anio, curso, pageable);
    }
}
