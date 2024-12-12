package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Departament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartamentRepository extends JpaRepository<Departament, Long> {

}
