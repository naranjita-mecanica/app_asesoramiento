package com.gym.backend.routes;

import com.gym.backend.interfaces.UsuarioRepo;
import com.gym.backend.models.Usuario;
import com.gym.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsuarioRoutes {

    @Autowired
    private UsuarioRepo usuarioRepo;

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/api/agregarUsuario")
    public Usuario PostUsuario(@RequestBody Usuario usuario) {
        return usuarioRepo.save(usuario);
    }

    @DeleteMapping("/api/eliminarUsuario/{id}")
    public void eliminarUsuario(@PathVariable int id) {
        usuarioService.eliminarUsuario(id);
    }

    @GetMapping("/api/buscarUsuario/{id}")
    public Usuario buscarUsuario(@PathVariable int id) {
        return usuarioService.buscarUsuario(id);
    }
}
