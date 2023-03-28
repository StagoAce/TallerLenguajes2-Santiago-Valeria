package com.base.datos.springbootdatajpa.Controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import com.base.datos.springbootdatajpa.Models.DAO.IClienteDao;
import com.base.datos.springbootdatajpa.Models.Entity.Cliente;

@Controller
@SessionAttributes("cliente")
public class ClienteController {
    
    @Autowired
    private IClienteDao clienteDao;

    @GetMapping("/listar")
    public String listar(Model model)
    {
        model.addAttribute("titulo", "Listado de clientes");
        model.addAttribute("clientes", clienteDao.findall());//los datos los trae por medio de una consulta
    
        return "listar";
    }

    @GetMapping("/form")
    public String create(Model model)
    {
        model.addAttribute("titlePage", "register User");
        Cliente cliente = new Cliente();

        model.addAttribute("titulo", "formulario de clientes");
        model.addAttribute("cliente", cliente);
        model.addAttribute("button", "registrar cliente");

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String guardar(@Valid Cliente cliente, BindingResult result, SessionStatus status, Model model)
    {
        if(result.hasErrors())
        {
            model.addAttribute("button", "guardar");
            model.addAttribute("titlePage", "Cliente");
            model.addAttribute("titulo", "formulario de clientes");
            return "form";
        }

        clienteDao.save(cliente);
        status.setComplete();
        return "redirect:listar";
    }

    @GetMapping("/form/{id}")
    public String editar(Model model, @PathVariable(value = "id") Long id)
    {
        model.addAttribute("titlePage", "Editar");
        Cliente cliente = null;

        if (id > 0) {
            cliente = clienteDao.findOne(id);
        } else {
            return "redirect:/listar";
        }

        model.addAttribute("titulo", "Editar Cliente");
        model.addAttribute("cliente", cliente);
        model.addAttribute("button", "guardar cambios");

        return "form";
    }

    @GetMapping("/eliminar/{Id}")
    public String eliminar(@PathVariable(value = "Id") Long id)
    {
        if (id>0)
        {
            clienteDao.delete(id);
        }
        return "redirect:/listar";
    }

    @GetMapping("/")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("home");

        modelAndView.addObject("titlePage", "home");
        modelAndView.addObject("titulo", "welcome back");

        return modelAndView;
    }

}
