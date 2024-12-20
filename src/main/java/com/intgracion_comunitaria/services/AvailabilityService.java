package com.intgracion_comunitaria.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Availability;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.repositories.AvailabilityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public void saveAvailability(Availability availability) {
        System.out.println("---GUARDANDO DISPONIBILIDAD: " + availability);
        availabilityRepository.save(availability);
    }

    public Map<Integer, Availability> getAvailabilityProvider(Long idProvider) {
        List<Availability> availabilities = availabilityRepository.findByProvider_IdProvider(idProvider);
        return availabilities.stream()
                .collect(Collectors.toMap(a -> a.getWeek().getIdWeek(), a -> a));
    }
}
