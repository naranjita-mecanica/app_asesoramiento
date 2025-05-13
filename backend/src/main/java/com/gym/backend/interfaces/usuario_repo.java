package com.gym.backend.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.backend.entities.Usuario;

public interface usuario_repo extends JpaRepository<Usuario,Integer>{

}
