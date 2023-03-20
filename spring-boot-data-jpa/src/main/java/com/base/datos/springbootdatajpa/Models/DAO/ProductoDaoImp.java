package com.base.datos.springbootdatajpa.Models.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.base.datos.springbootdatajpa.Models.Entity.Producto;

@Repository
public class ProductoDaoImp implements IProductoDao{

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    @Override
    public List<Producto> findall() {
        return em.createQuery("from Producto").getResultList();
    }
    
}
