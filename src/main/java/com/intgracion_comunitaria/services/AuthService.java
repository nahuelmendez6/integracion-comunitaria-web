package com.intgracion_comunitaria.services;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.repositories.UserRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthService {

    // Inyeccion de dependencias

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Metodo para autenticar al usuario
    public Optional<User> authenticate(String email, String password) {

        // Busca si el email pasado como argumento esta registrado

        Optional<User> userOptional = userRepository.findByEmail(email);

        // Verifica si el usuario con ese email existe
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Verifica si la contraseña es correcta
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();

    }

}
