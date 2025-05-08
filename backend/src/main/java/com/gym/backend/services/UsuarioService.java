package com.gym.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.backend.interfaces.UsuarioRepo;
import com.gym.backend.models.Usuario;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepo.save(usuario); // Devuelve el usuario guardado
    }

    public Usuario eliminarUsuario(int id) {
        Usuario usuario = usuarioRepo.findById(id).orElse(null);
        if (usuario != null) {
            usuarioRepo.deleteById(id);
        }
        return usuario;
    }

    public Usuario buscarUsuario(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
