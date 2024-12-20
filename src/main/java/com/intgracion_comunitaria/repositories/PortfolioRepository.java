package com.intgracion_comunitaria.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intgracion_comunitaria.model.Portfolio;

public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    List<Portfolio> findByProviderId(Integer providerId);

}
