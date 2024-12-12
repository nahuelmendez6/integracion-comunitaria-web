package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {
    // Método para obtener el perfil de usuario por el id del usuario
    UserProfile findByUserId(Integer userId);

    // UserProfile findByEmail(String userEmail);
}
