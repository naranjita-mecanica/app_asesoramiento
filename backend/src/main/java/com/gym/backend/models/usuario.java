package com.gym.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="usuario")
@Entity
public class usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "edad")
    private int edad;

    @Column(name = "peso")
    private double peso;

    @Column(name="altura")
    private double altura;

    @Column(name = "experiencia")
    private int experiencia;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre()
    {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido()
    {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad()
    {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia()
    {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public double getPeso()
    {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura()
    {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    
    /*
    Este seria para calcular el IMC en el futuro
    public double setIMC(double imc, double altura, double peso) {
        return peso / (altura * altura);
    }
    */
}
