package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.TypeProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeProviderRepository extends JpaRepository<TypeProvider, Long> {

}
