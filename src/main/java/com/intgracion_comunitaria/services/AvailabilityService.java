package com.intgracion_comunitaria.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Availability;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.repositories.AvailabilityRepository;

@Service
public class AvailabilityService {
    @Autowired
    private AvailabilityRepository availabilityRepository;

    public void saveAvailability(Availability availability) {
        // Verifica si ya existe una disponibilidad para el proveedor y semana
        Availability existingAvailability = availabilityRepository
                .findByProviderAndWeek(availability.getProvider(), availability.getWeek());

        if (existingAvailability != null) {
            // Actualiza la disponibilidad existente
            existingAvailability.setFromHour(availability.getFromHour());
            existingAvailability.setUntilHour(availability.getUntilHour());
            availabilityRepository.save(existingAvailability);
        } else {
            // Crea una nueva disponibilidad
            availabilityRepository.save(availability);
        }
    }

    public Map<Integer, Availability> getAvailabilityProvider(Long idProvider) {
        List<Availability> availabilities = availabilityRepository.findByProvider_IdProvider(idProvider);
        return availabilities.stream()
                .collect(Collectors.toMap(a -> a.getWeek().getIdWeek(), a -> a));
    }
}
