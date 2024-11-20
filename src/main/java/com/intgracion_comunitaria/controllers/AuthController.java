package com.intgracion_comunitaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;

import com.intgracion_comunitaria.services.UserRegistrationService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    // Inyectamos la dependencia con la que trabajaremos el registro de los usuarios

    @Autowired
    private UserRegistrationService userRegistrationService;

    @GetMapping("/home")
    public String home(Authentication authentication, Model model) {
        if (authentication != null && authentication.isAuthenticated()) {
            model.addAttribute("username", authentication.getName()); // Agregar el nombre de usuario al modelo
        }
        return "home"; // Redirige a la página de inicio si el usuario está autenticado
    }

    // Endpoint para mostrar el formulario de registro
    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User()); // Se pasa el objeto User al modelo
        return "register";
    }

    // Endpoint para manejar el registro de usuarios
    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, @RequestParam String role) {
        // Llamada al servicio para registrar al usuario con su rol
        UserProfile.RoleType roleType = UserProfile.RoleType.valueOf(role.toUpperCase());
        userRegistrationService.registerUser(user, roleType, null);

        // Redirigir al login
        return "redirect:/login";
    }

    // Mostrar formulario de login
    @GetMapping("/login")
    public String login() {
        return "login"; // Devuelve la vista de login
    }

}
