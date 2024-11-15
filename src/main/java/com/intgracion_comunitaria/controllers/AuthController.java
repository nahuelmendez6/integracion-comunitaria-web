package com.intgracion_comunitaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.services.UserRegistrationService;

@Controller
public class AuthController {

    // Inyectamos la dependencia con la que trabajaremos el registro de los usuarios

    @Autowired
    private UserRegistrationService userRegistrationService;

    // Endpoint para mostrar el formulario de registro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Se pasa el objeto User al modelo
        return "register";
    }

}
