package com.gym.backend.routes;

import com.gym.backend.models.Usuario;
import com.gym.backend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioRoutes {

    @Autowired
    private UsuarioService usuriosevice;

    //Mientras hay que poner el id de forma manual, se puede usar el postman para probar la api
    @PostMapping("/api/usuario/agrergar")
    public Usuario  postUsuario(@RequestBody Usuario usuario) {
        return usuriosevice.guardarUsuario(usuario);
    }

}
