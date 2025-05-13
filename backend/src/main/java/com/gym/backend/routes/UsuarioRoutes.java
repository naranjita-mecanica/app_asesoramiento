package com.gym.backend.routes;

import com.gym.backend.models.Usuario;
import com.gym.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRoutes {

    @Autowired
    private UsuarioService usuariosevice;

    @PostMapping("/api/usuario/agrergar")
    public Usuario postUsuario(@RequestBody Usuario usuario) {
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
