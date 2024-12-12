package com.intgracion_comunitaria.services;

import java.lang.foreign.Linker.Option;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Hour;
import com.intgracion_comunitaria.repositories.HourRepository;

@Service
public class HourService {

    @Autowired
    private HourRepository hourRepository;

    public List<Hour> getAllHours() {
        return hourRepository.findAll();
    }

    public Optional<Hour> findById(Long fromHourId) {
        return hourRepository.findById(fromHourId);
    }

}
