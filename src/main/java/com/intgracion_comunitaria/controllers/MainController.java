package com.intgracion_comunitaria.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    /*
     * @GetMapping("/home")
     * public String home(Authentication authentication, Model model) {
     * if (authentication != null && authentication.isAuthenticated()) {
     * model.addAttribute("username", authentication.getName());
     * }
     * return "home";
     * }
     */

}
