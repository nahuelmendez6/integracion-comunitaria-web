package com.intgracion_comunitaria.controllers;

//import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.intgracion_comunitaria.model.Portfolio;
import com.intgracion_comunitaria.services.PortfolioService;

@Controller
public class PortfolioController {

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping("/provider/portfolios/{providerId}")
    public List<Portfolio> getPortfoliosByProvider(@PathVariable Integer providerId) {
        return portfolioService.getPortfoliosProvider(providerId);
    }

    @PostMapping
    public Portfolio createPortfolio(@RequestBody Portfolio portfolio) {
        return portfolioService.createPortfolio(portfolio);
    }

    @PutMapping("/provider/portfolios/{idPortfolio}")
    public Portfolio updatePortfolio(@PathVariable Long idPortfolio, @RequestBody Portfolio portfolio) {
        return portfolioService.updatePortfolio(idPortfolio, portfolio);
    }

    @DeleteMapping("/provider/portfolios/{idPortfolio}")
    public void deltePortfolio(@PathVariable Long idPortfolio) {
        portfolioService.deletePortfolio(idPortfolio);
    }

}
