package com.intgracion_comunitaria.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intgracion_comunitaria.repositories.CustomerRepository;
import com.intgracion_comunitaria.repositories.UserProfileRepository;
import com.intgracion_comunitaria.repositories.UserRepository;
import com.intgracion_comunitaria.repositories.ProviderRepository;
import com.intgracion_comunitaria.repositories.AddressRepository;
import com.intgracion_comunitaria.model.Address;
import com.intgracion_comunitaria.model.Customer;
import com.intgracion_comunitaria.model.Provider;
import com.intgracion_comunitaria.model.User;
import com.intgracion_comunitaria.model.UserProfile;

@Service
@Transactional
public class UserRegistrationService {

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

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Transactional
    public User registerUser(User user, UserProfile.RoleType roleType, Address address) {

        // Encriptar la contraseña antes de guardar el usuario
        user.setPassword(encodePassword(user.getPassword()));

        // Paso 1: Guarda la información básica del usuario
        User savedUser = userRepository.save(user);
        // User savedUser = userRepository.save(user);

        // Paso 2: Crear y asignar el perfil de usuario (guardar en user_profile)
        UserProfile userProfile = new UserProfile();
        userProfile.setUser(savedUser);
        userProfile.setRoleType(roleType);
        userProfileRepository.save(userProfile);

        // Paso 3: Guardar la dirección del usuario
        if (address != null) {
            address.setUser(savedUser);
            addressRepository.save(address);
        }

        // Paso 4: Crear el perfil de cliente o proveedor
        switch (roleType) {
            case CLIENTE:
                Customer customer = new Customer();
                customer.setUser(user);
                customerRepository.save(customer);
                break;

            case PROVEEDOR:
                Provider provider = new Provider();
                provider.setUser(user);
                provider.setName(user.getName());
                providerRepository.save(provider);
                break;

            case AMBOS:
                Customer customerBoth = new Customer();
                customerBoth.setUser(user);
                customerRepository.save(customerBoth);

                Provider providerBoth = new Provider();
                providerBoth.setUser(user);
                providerRepository.save(providerBoth);
                break;
        }

        return user;
    }

    // Método para encriptar la contraseña
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }
}
