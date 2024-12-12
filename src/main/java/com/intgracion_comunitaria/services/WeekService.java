package com.intgracion_comunitaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Week;
import com.intgracion_comunitaria.repositories.WeekRepository;

@Service
public class WeekService {
    @Autowired
    private WeekRepository weekRepository;

    public Week findById(Integer id) {
        return weekRepository.findByIdWeek(id);
    }

    public List<Week> getAllWeeks() {
        return weekRepository.findAll();
    }
}
