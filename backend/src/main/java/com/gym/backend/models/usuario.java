package com.gym.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name="usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "edad")
    private int edad;

    @Column(name = "sexo")
    private char sexo;

    @Column(name = "peso")
    private double peso;

    @Column(name="altura")
    private double altura;

    @Column(name = "experiencia")
    private int experiencia;

    @Column(name = "imc")
    private double imc;

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

    public int getEdad()
    {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo()
    {
        return sexo;
    }
    public void setSexo(char sexo) {
        if (sexo == 'M' || sexo == 'F') {
            this.sexo = sexo;
        } else {
            throw new IllegalArgumentException("Sexo debe ser 'M' o 'F'");
            
        }
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
        calcularImc();
    }

    public double getAltura()
    {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
        calcularImc();
    }

    public double getIMC()
    {
        return imc;
    }
    public void calcularImc() {
        this.imc = peso / (altura * altura);
    }
}
