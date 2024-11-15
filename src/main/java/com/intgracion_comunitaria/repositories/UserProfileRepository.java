package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    /*
     * CustomerRepository interactua con la tabla customer y permite buscar un
     * cliente a partir del id de usuario
     */

    // Buscar un cliente por su id de usuario
    Optional<User> findByUserID(Long userID);

    UserProfile findByProfileId(Long profileID);

}
