package com.intgracion_comunitaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intgracion_comunitaria.repositories.CustomerRepository;
import com.intgracion_comunitaria.repositories.UserProfileRepository;
import com.intgracion_comunitaria.repositories.UserRepository;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.model.Address;
import com.intgracion_comunitaria.model.Customer;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;
import com.intgracion_comunitaria.repositories.AddressRepository;

@Service
public class UserRegistrationService {

    // Inyectamos repositorios
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProviderRepository providerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public User registerUser(User user, UserProfile.RoleType roleType, Address address) {

        // Paso 1: Guarda la informacion basica del usuario en user
        User savedUser = userRepository.save(user);

        // Paso 2: Crear y asignar el perfil de usuario (guardar en user_profile)
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(savedUser);
        userProfile.setRoleType(roleType);
        userProfileRepository.save(userProfile);

        // Paso 3: Guardar la direccion del usuario en la tabla address
        if (address != null) {
            address.setUser(savedUser); // asociar la direccion del usuario
            addressRepository.save(address); // guardar la direccion
        }

        // Paso 4: Crear y utilizar la informacion adicional en customer o provider
        switch (roleType) {
            case CLIENTE:
                Customer customer = new Customer();
                customer.setUser(savedUser);
                customerRepository.save(customer);
                break;

            case PROVEEDOR:
                Provider provider = new Provider();
                provider.setUser(savedUser);
                providerRepository.save(provider);
                break;

            case AMBOS:
                // Crear un customer
                Customer customerBoth = new Customer();
                customerBoth.setUser(savedUser);
                customerRepository.save(customerBoth);

                // Crear un provider
                Provider providerBoth = new Provider();
                providerBoth.setUser(savedUser);
                providerRepository.save(providerBoth);

                break;

        }

        return savedUser;

    }

}
