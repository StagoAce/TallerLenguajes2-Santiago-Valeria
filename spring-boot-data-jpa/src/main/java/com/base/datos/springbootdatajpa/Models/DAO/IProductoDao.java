package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import com.base.datos.springbootdatajpa.Models.Entity.Producto;

public interface IProductoDao {
    public List<Producto> findall();
}
