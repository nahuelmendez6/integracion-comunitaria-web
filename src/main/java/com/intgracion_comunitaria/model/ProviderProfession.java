package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "provider_profession")
public class ProviderProfession {

    @EmbeddedId
    private ProviderProfessionId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProvider")
    @JoinColumn(name = "id_provider", nullable = false)
    private Provider provider;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProfession")
    @JoinColumn(name = "id_profession", nullable = false)
    private Profession profession;

    // Constructor vacío
    public ProviderProfession() {
    }

    // Constructor con parámetros
    /*
     * public ProviderProfession(Provider provider, Profession profession) {
     * this.provider = provider;
     * this.profession = profession;
     * this.id = new ProviderProfessionId(provider.getIdProvider(),
     * profession.getIdProfession());
     * }
     */

    // Getters y Setters
    public ProviderProfessionId getId() {
        return id;
    }

    public void setId(ProviderProfessionId id) {
        this.id = id;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    // Métodos equals y hashCode basados en la clave compuesta
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProviderProfession that = (ProviderProfession) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
