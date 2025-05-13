package com.gym.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Table(name="usuario")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "El nombre no puede estar vacío")
    @Column(name = "nombre")
    private String nombre;

    @Positive(message = "La edad debe ser un número positivo")
    @Digits(integer = 2, fraction = 0, message = "La edad debe ser un número entero")
    @NotNull(message = "La edad no puede ser nula")
    @Column(name = "edad")
    private int edad;

    @NotNull(message = "El sexo no puede ser nulo")
    @Column(name = "sexo")
    private char sexo;

    @Positive(message = "El peso no puede ser negativo")
    @NotNull(message = "El peso no puede ser nulo")
    @Column(name = "peso")
    private double peso;

    @Positive(message = "La altura no puede ser negativa")
    @NotNull(message = "La altura no puede ser nula")
    @Column(name="altura")
    private double altura;

    @NotNull(message = "Debe ingresar un nivel de experiencia")
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
