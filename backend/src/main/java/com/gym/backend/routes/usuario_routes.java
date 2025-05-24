package com.gym.backend.routes;


import com.gym.backend.entities.Usuario;
import com.gym.backend.services.usuario_service;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
@CrossOrigin
public class usuario_routes {

    @Autowired
    private usuario_service usuariosevice;

    @PostMapping("/api/usuario/agregar")
    public Usuario postUsuario(@Valid @RequestBody Usuario usuario) {
        if(usuario.getPeso() > 400.0) {
            throw new RuntimeException("Error: El peso debe ser menor a 400 kg.");
        }
        if(usuario.getAltura() > 400.0) {
            throw new RuntimeException("Error: La altura debe ser menor a 400 cm.");
        }
        return usuariosevice.guardarUsuario(usuario);
    }

    @DeleteMapping("/api/usuario/eliminar/{id}")
    public String deleteUsuario(@PathVariable("id") int id) {
        Usuario usuarioExistente = usuariosevice.buscarUsuario(id);
        if (usuarioExistente != null) {
            usuariosevice.eliminarUsuario(id);
            return "Usuario eliminado correctamente.";
        } else {
            return "Error: Usuario no encontrado.";
        }
    }

    @GetMapping("/api/usuario/buscar/{id}")
    public Usuario getUsuario(@PathVariable("id") int id) {
        Usuario usuarioExistente = usuariosevice.buscarUsuario(id);
        if (usuarioExistente != null) {
            return usuarioExistente;
        } else {
            throw new RuntimeException("Error: Usuario no encontrado.");
        }
    }
}
