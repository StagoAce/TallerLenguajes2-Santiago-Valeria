package com.base.datos.springbootdatajpa.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("login")
public class loginController {


    @GetMapping("/login")
    public String login(Model model)
    {
        model.addAttribute("titlePage", "LOGIN");
        model.addAttribute("title", "Iniciar sesion");

        return "login";
    }

    @GetMapping("registrar")
    public String register(Model model)
    {
        model.addAttribute("titulo", "registrar");
        model.addAttribute("titlePage", "registrar");
        return "usuarios/user";
    }

    
}
