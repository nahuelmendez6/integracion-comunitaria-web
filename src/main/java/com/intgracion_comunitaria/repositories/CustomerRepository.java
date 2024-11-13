package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /*
     * CustomerRepository interactua con la tabla customer y permite buscar un
     * cliente a partir del id de usuario
     */

    // Buscar un cliente por su id de usuario
    Customer findByUserID(Long userID);

}
