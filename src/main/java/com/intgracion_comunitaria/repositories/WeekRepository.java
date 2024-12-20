package com.intgracion_comunitaria.repositories;

import java.util.Optional;
import com.intgracion_comunitaria.model.Week;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepository extends JpaRepository<Week, Long> {

    Optional<Week> findByIdWeek(Integer idWeek);

}
