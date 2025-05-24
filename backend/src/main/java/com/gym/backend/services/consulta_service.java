package com.gym.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gym.backend.entities.Consulta;
import com.gym.backend.interfaces.consulta_repo;

@Service
public class consulta_service {
    @Autowired
    private consulta_repo consultaRepo;

    public Consulta guardarConsulta(Consulta consulta)
    {
        return consultaRepo.save(consulta);
    }

    public Consulta eliminarConsulta(int id) {
        Consulta consulta = consultaRepo.findById(id).orElse(null);
        if (consulta != null) {
            consultaRepo.deleteById(id);
        }
        return consulta;
    }
}
