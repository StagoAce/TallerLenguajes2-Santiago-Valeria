package com.base.datos.springbootdatajpa.Models.DAO;

import com.base.datos.springbootdatajpa.Models.Entity.Usuario;

public interface IUsuarioDao {

    public Usuario findByUsername(String username);
    
}
