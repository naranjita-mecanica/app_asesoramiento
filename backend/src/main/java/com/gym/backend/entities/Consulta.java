package com.gym.backend.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "consulta")
@Entity
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    
    @Column(name = "mensaje")
    private String mensaje;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMensaje()
    {
        return mensaje;
    }

    public void setMensaje(String mensaje)
    {
        this.mensaje = mensaje;
    }

}
