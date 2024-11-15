package com.intgracion_comunitaria.repositories;

import com.intgracion_comunitaria.model.Address;
import com.intgracion_comunitaria.model.Country;
import com.intgracion_comunitaria.model.Province;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

    // Buscar direcciones por el ID del usuario
    // List<Address> findByUserId(int userId);

    // Buscar direcciones por ciudad
    // List<Address> findByCityName(String cityName);

    // Buscar direcciones por código postal
    // List<Address> findByPostalCode(String postalCode);

    // Buscar direcciones por GPS Latitude (coordenadas aproximadas)
    // List<Address> findByGpsLatBetween(BigDecimal startLat, BigDecimal endLat);

    // Buscar direcciones por provincia y país
    // List<Address> findByProvinceAndCountry(Province province, Country country);

    // Buscar direcciones asociadas a un cliente específico
    // List<Address> findByCustomerId(int customerId);

    // Buscar direcciones asociadas a un proveedor específico
    // List<Address> findByProviderId(int providerId);

}
