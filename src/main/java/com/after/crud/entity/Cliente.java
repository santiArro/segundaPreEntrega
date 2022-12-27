package com.after.crud.entity;

import jakarta.persistence.*;

//entidad
@Entity
@Table(name = "CLIENTE")
public class Cliente {
    //a contuanicion creamos la entidades
    @Id
    //Identity para ir incrementanto
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    //Nombres en base de datos
    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "DNI")
    private String dni;
//creamos los Set y Get para cada entidad
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
