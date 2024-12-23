package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Profession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionRepository extends JpaRepository<Profession, Long> {

}
