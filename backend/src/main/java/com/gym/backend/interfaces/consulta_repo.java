package com.gym.backend.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gym.backend.entities.Consulta;

public interface consulta_repo extends JpaRepository<Consulta,Integer>{
    
}
