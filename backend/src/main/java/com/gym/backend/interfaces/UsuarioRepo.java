package com.gym.backend.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.backend.models.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario,Integer>{

}
