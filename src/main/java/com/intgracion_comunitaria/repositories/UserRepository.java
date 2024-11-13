package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    /*
     * UserRepository interactua con la tabla user y permite realizar busqeudas por
     * correo electronico y verificar la existencias de usuarios
     */

    // Buscar un usuario por su correo electronico
    Optional<User> findByEmail(String email);

    // Verificar si existe un usuario por su correo electronico
    boolean existsByEmail(String email);

}
