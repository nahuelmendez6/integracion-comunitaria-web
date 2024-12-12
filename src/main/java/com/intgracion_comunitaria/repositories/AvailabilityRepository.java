package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Availability;
import com.intgracion_comunitaria.model.Week;
import com.intgracion_comunitaria.model.Provider;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    List<Availability> findByProvider_IdProvider(Long idProvider);

    Availability findById(Integer idAvailability);

    Availability findByProviderAndWeek(Provider provider, Week week);
}
