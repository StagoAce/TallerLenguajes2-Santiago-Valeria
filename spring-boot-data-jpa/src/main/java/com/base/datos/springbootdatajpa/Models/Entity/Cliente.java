package com.base.datos.springbootdatajpa.Models.Entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "clientes")

public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotEmpty(message = "{NotEmpty.Cliente.Nombre}")
    private String Nombre;

    @NotEmpty(message = "{NotEmpty.Cliente.Apellido}")
    private String Apellido;

    @Email(message = "{Email.Cliente.Email}")
    @NotEmpty(message = "{NotEmpty.Cliente.Email}")
    private String Email;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "{NotNull.Cliente.Fecha}")
    @PastOrPresent(message = "{PastOrPresent.Cliente.Fecha}")
    private Date Fecha;

    /* 
    @PrePersist
    public void PrePersist()//toma el valor del sistema y lo guarda
    {
        Fecha = new Date();
    }
    */

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date fecha) {
        Fecha = fecha;
    }

    
    
}
