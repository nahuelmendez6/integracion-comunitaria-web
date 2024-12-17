package com.intgracion_comunitaria.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.Category;
import com.intgracion_comunitaria.model.Profession;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.model.TypeJornal;
import com.intgracion_comunitaria.model.TypeProvider;
import com.intgracion_comunitaria.repositories.CategoryRepository;
import com.intgracion_comunitaria.repositories.ProfessionRepository;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.repositories.TypeJornalrepository;
import com.intgracion_comunitaria.repositories.TypeProviderRepository;

@Service
public class ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProfessionRepository professionRepository;

    @Autowired
    private TypeProviderRepository typeProviderRepository;

    @Autowired
    private TypeJornalrepository typeJornalrepository;

    public Provider findById(Long id) {
        return providerRepository.findById(id).orElse(null);
    }

    public List<Category> getAllCategories() {
        // Devuelve todas las categorías disponibles
        return categoryRepository.findAll();
    }

    public List<Profession> getAllProfessions() {
        return professionRepository.findAll();
    }

    public List<TypeProvider> getAllTypeProviders() {
        return typeProviderRepository.findAll();
    }

    public List<TypeJornal> getAllTypeJornals() {
        return typeJornalrepository.findAll();
    }

    public void updateProvider(Provider provider) {
        // Update the provider in the database
        Provider existingProvider = providerRepository.findById(provider.getIdProvider())
                .orElseThrow(() -> new RuntimeException("Provider not found"));

        existingProvider.setName(provider.getName());
        existingProvider.setCategory(provider.getCategory());
        existingProvider.setProfession(provider.getProfession());
        existingProvider.setTypeProvider(provider.getTypeProvider());
        existingProvider.setTypeJornal(provider.getTypeJornal());
        // Add any additional fields you want to update

        providerRepository.save(existingProvider);
    }

}
