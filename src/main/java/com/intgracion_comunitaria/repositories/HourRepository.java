package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Hour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HourRepository extends JpaRepository<Hour, Long> {

}
