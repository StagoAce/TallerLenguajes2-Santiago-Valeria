package com.base.datos.springbootdatajpa.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("producto")
@RequestMapping("/productos")
public class ProductoController {

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

        return "productos/form";
    }

    
}
