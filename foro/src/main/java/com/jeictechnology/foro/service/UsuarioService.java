package com.jeictechnology.foro.service;

import com.jeictechnology.foro.domain.perfil.Perfil;
import com.jeictechnology.foro.domain.usuario.Usuario;
import com.jeictechnology.foro.dto.usuario.DatosUsuario;
import com.jeictechnology.foro.dto.usuario.DatosUsuarioRespuesta;
import com.jeictechnology.foro.repository.IUsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    private final IUsuarioRepository iUsuarioRepository;

    private final PasswordEncoder passwordEncoder;

    public UsuarioService(IUsuarioRepository iUsuarioRepository, PasswordEncoder passwordEncoder) {
        this.iUsuarioRepository = iUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public DatosUsuarioRespuesta crearUsuario(DatosUsuario datosUsuario) {
        Usuario usuario = new Usuario();
        usuario.setNombre(datosUsuario.nombre());
        usuario.setEmail(datosUsuario.email());
        usuario.setContrasena(passwordEncoder.encode(datosUsuario.contrasena()));
        usuario.setPerfil(Perfil.ESTUDIANTE);

        Usuario usuarioGuardado = iUsuarioRepository.save(usuario);

        return new DatosUsuarioRespuesta(usuarioGuardado.getNombre(), usuarioGuardado.getPerfil());

    }

    public Usuario obtenerUsuarioById(Long id){
        return iUsuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }
}
