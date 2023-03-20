package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import com.base.datos.springbootdatajpa.Models.Entity.Producto;

public interface IProductoDao {
    public List<Producto> findall();

    public void save(Producto producto);

    public Producto findOne(Long Id);

    public void delete(Long Id);
}
