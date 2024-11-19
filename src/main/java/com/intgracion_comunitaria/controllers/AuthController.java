package com.intgracion_comunitaria.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties.Authentication;
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
import com.intgracion_comunitaria.services.AuthService;
import com.intgracion_comunitaria.services.UserRegistrationService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    // Inyectamos la dependencia con la que trabajaremos el registro de los usuarios

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private AuthService authService;

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
        return "login";
    }

    // Mostrar formulario de login

    @GetMapping("/login")
    public String showLoginForm(Authentication authentication) {
        // Verificar si el usuario ya esta autenticado
        if (authentication != null) {
            return "home";
        }
        return "login"; // Devuelve la vista login.html
    }

    // Procesar la solicitud de login
    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
            @RequestParam("password") String password,
            Model model,
            HttpServletRequest request) {

        // Llamamos al servicio de autenticacion

        Optional<User> userOptional = authService.authenticate(email, password);

        // Si la autenticacion es exitosa
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Aca se puede guardar al usuario en el contexto de seguridad
            // SecurityContextHolder.getContext().setAuthentication(auth); Configurar Sring
            // Security

            return "home";

        } else {
            model.addAttribute("error", "Credenciales incorrectas.");
            return "login"; // Si la autenticacion falla, vuelve a mostrar el login
        }

    }

}
