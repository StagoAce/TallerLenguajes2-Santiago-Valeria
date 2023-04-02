package com.base.datos.springbootdatajpa.Models.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.base.datos.springbootdatajpa.Models.Entity.Usuario;

public class UsuarioDaoImp implements IUsuarioDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Usuario findByUsername(String username) {
        return (Usuario) em.createQuery("from Producto us where us.username = "+username+"").getSingleResult();
    }
    
}
