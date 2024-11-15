package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {

    /*
     * ProviderRepository interactua con la tabla provider y permite buscar a un
     * proveedor mediante su id de usuario
     */

    // Buscar un proveedor por su ID de usuario
    Provider findByUserId(Long userId);

}
