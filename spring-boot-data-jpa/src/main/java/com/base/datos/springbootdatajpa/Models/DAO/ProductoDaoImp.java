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

    @Override
    @Transactional
    public void save(Producto producto) {
        if(producto.getId() != null && producto.getId() > 0) {
            em.merge(producto);
        } else {
            em.persist(producto);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Producto findOne(Long Id) {
        return em.find(Producto.class, Id);
    }

    @Override
    @Transactional
    public void delete(Long Id) {
        Producto producto = findOne(Id);

        em.remove(producto);
    }
    
}
