package com.gym.backend.routes;


import com.gym.backend.models.usuario;
import com.gym.backend.services.usuario_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class usuario_routes {

    @Autowired
    private usuario_service usuariosevice;

    @PostMapping("/api/usuario/agrergar")
    public usuario postUsuario(@RequestBody usuario usuario) {
        return usuariosevice.guardarUsuario(usuario);
    }

    @DeleteMapping("/api/usuario/eliminar/{id}")
    public String deleteUsuario(@PathVariable("id") int id) {
        usuario usuarioExistente = usuariosevice.buscarUsuario(id);
        if (usuarioExistente != null) {
            usuariosevice.eliminarUsuario(id);
            return "Usuario eliminado correctamente.";
        } else {
            return "Error: Usuario no encontrado.";
        }
    }

    @GetMapping("/api/usuario/buscar/{id}")
    public usuario getUsuario(@PathVariable("id") int id) {
        usuario usuarioExistente = usuariosevice.buscarUsuario(id);
        if (usuarioExistente != null) {
            return usuarioExistente;
        } else {
            throw new RuntimeException("Error: Usuario no encontrado.");
        }
    }
}
