package com.intgracion_comunitaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_zone")
    private Integer idZone;

    @Column(name = "name", length = 255)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    private Integer country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_province", referencedColumnName = "id_province")
    private Integer province;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_departament", referencedColumnName = "id_departament")
    private Departament departament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_city", referencedColumnName = "id_city")
    private City city;

    // Getters y Setters

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    public Integer getProvince() {
        return province;
    }

    public void setProvince(Integer province) {
        this.province = province;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
