package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.TypeJornal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeJornalrepository extends JpaRepository<TypeJornal, Long> {

}
