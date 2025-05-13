package com.gym.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.backend.interfaces.usuario_repo;
import com.gym.backend.models.usuario;

@Service
public class usuario_service {
    @Autowired
    private usuario_repo usuarioRepo;

    public usuario guardarUsuario(usuario usuario) {
        return usuarioRepo.save(usuario); // Devuelve el usuario guardado
    }

    public usuario eliminarUsuario(int id) {
        usuario usuario = usuarioRepo.findById(id).orElse(null);
        if (usuario != null) {
            usuarioRepo.deleteById(id);
        }
        return usuario;
    }

    public usuario buscarUsuario(int id) {
        return usuarioRepo.findById(id).orElse(null);
    }
}
