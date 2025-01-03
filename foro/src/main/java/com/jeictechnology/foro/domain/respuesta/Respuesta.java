package com.jeictechnology.foro.domain.respuesta;

import com.jeictechnology.foro.domain.topico.Topico;
import com.jeictechnology.foro.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "respuestas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    @ManyToOne
    @JoinColumn(name = "topico")
    private Topico topico;
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "autor")
    private Usuario autor;
    private Boolean solucion;

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public void setTopico(Topico topico) {
        this.topico = topico;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Topico getTopico() {
        return topico;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Boolean getSolucion() {
        return solucion;
    }

    public void setSolucion(Boolean solucion) {
        this.solucion = solucion;
    }
}
