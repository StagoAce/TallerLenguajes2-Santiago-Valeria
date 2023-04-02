package com.base.datos.springbootdatajpa.Models.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "{NotEmpty.Producto.Nombre}")
    private String Nombre;

    @NotEmpty(message = "{NotEmpty.Producto.Descripcion}")
    private String Descripcion;

    @Min(value = 0, message = "{Min.Producto.CantidadUnidades}")
    private int CantidadUnidades;

    @NotNull(message = "{NotNull.Producto.Precio}")
    private Float Precio;
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getDescripcion() {
        return Descripcion;
    }
    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
    public int getCantidadUnidades() {
        return CantidadUnidades;
    }
    public void setCantidadUnidades(int cantidadUnidades) {
        CantidadUnidades = cantidadUnidades;
    }
    public Float getPrecio() {
        return Precio;
    }
    public void setPrecio(Float precio) {
        Precio = precio;
    }

    

}
