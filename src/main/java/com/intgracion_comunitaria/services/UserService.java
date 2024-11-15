package com.intgracion_comunitaria.services;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    // Inyeccion de dependencias

    @Autowired // Inyectamos UserRepository
    private UserRepository userRepository;

    @Autowired // Inyectamos PasswordEncoder
    private PasswordEncoder passwordEncoder;

    // Método para registrar un nuevo usuario
    public User registerUser(User user) {
        // Verifica si el email ya está registrado
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("El email ya está en uso.");
        }
        // Encripta la contraseña antes de guardar
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    // Método para obtener un usuario por su ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para obtener un usuario por su email
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
