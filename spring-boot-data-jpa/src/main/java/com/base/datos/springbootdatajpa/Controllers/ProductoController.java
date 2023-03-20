package com.base.datos.springbootdatajpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.base.datos.springbootdatajpa.Models.DAO.IProductoDao;
import com.base.datos.springbootdatajpa.Models.Entity.Producto;


@Controller
@SessionAttributes("producto")
@RequestMapping("/productos")
public class ProductoController {
    
    @Autowired
    private IProductoDao productoDao;

    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titlePage", "productos");

        return "productos/listar";
    }

    @GetMapping("/form")
    public String create(Model model)
    {
        model.addAttribute("titlePage", "registrar");
        Producto producto = new Producto();

        model.addAttribute("titulo", "FORMULARIO PRODUCTO");
        model.addAttribute("producto", producto);
        model.addAttribute("button", "Registrar");

        return "productos/form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(Producto producto, SessionStatus status)
    {
        productoDao.save(producto);
        status.setComplete();
        return "redirect:/productos/listar";
    }

    @GetMapping("/form/{id}")
    public String editar(Model model, @PathVariable(value = "id") Long id) {

        model.addAttribute("titlePage", "editar");
        Producto producto = null;

        if (id > 0) {
            producto = productoDao.findOne(id);
        } else {
            return "redirect:/productos/listar";
        }

        model.addAttribute("titulo", "EDITAR DATOS DE PRODUCTO");
        model.addAttribute("producto", producto);
        model.addAttribute("button", "Actualizar");

        return "productos/form";
    }

    @GetMapping("/eliminar/{Id}")
    public String eliminar(@PathVariable(value = "Id") Long id)
    {
        if (id>0)
        {
            productoDao.delete(id);
        }
        return "redirect:/productos/listar";
    }

    
}
