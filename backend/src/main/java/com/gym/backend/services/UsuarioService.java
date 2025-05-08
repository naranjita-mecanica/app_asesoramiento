package com.gym.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.backend.entities.Usuario;
import com.gym.backend.interfaces.UsuarioRepo;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepo usuarioRepo;

    public void guardarUsuario(Usuario usuario) {
        usuarioRepo.save(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioRepo.deleteById(id);
    }

    public Usuario buscarUsuario(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
