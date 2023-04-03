package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import com.base.datos.springbootdatajpa.Models.Entity.Cliente;

public interface IClienteDao
{
    public List<Cliente>findall();    

    public void save(Cliente cliente);

    public Cliente findOne(Long Id);

    public void delete(Long Id);

    
}
