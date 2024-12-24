package com.intgracion_comunitaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Portfolio;
import com.intgracion_comunitaria.repositories.PortfolioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PortfolioService {

    @Autowired
    private PortfolioRepository portfolioRepository;

    public Optional<Portfolio> getPortfolioById(Long idPortfolio) {
        return portfolioRepository.findById(idPortfolio);
    }

    public List<Portfolio> getPortfoliosProvider(Integer providerId) {
        return portfolioRepository.findByProvider_IdProvider(providerId);
    }

    public Portfolio createPortfolio(Portfolio portfolio) {
        return portfolioRepository.save(portfolio);
    }

    public Portfolio updatePortfolio(Long idPortfolio, Portfolio portfolioDetails) {
        Portfolio portfolio;
        Optional<Portfolio> portfolioOpt = portfolioRepository.findById(idPortfolio);
        portfolio = portfolioOpt.get();
        portfolio.setName(portfolioDetails.getName());
        portfolio.setDescription(portfolioDetails.getDescription());
        return portfolioRepository.save(portfolio);

    }

    public void deletePortfolio(Long idPortfolio) {
        portfolioRepository.deleteById(idPortfolio);
    }

}
