package com.intgracion_comunitaria.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intgracion_comunitaria.model.UserProfile;
import com.intgracion_comunitaria.repositories.CustomerRepository;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.repositories.UserProfileRepository;

@Service
public class ProfileService {

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProviderRepository providerRepository;

    public Object getProfileByUserId(Integer userId) {
        // Obtener el perfil del usuario
        UserProfile userProfile = userProfileRepository.findByUserId(userId);

        // Determinar el rol y cargar el perfil correspondiente
        switch (userProfile.getRoleType()) {
            case cliente:
                return customerRepository.findByUserId(userId);
            case proveedor:
                return providerRepository.findByUserId(userId);
            case ambos:
                // Si el usuario tiene ambos roles, devuelve un mapa con ambos perfiles
                Map<String, Object> profiles = new HashMap<>();
                profiles.put("cliente", customerRepository.findByUserId(userId));
                profiles.put("proveedor", providerRepository.findByUserId(userId));
                return profiles;
            default:
                throw new RuntimeException("Rol no reconocido");
        }
    }
}
