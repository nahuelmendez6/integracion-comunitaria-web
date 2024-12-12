package com.intgracion_comunitaria.model;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProviderProfessionId implements Serializable {

    private Integer idProvider;
    private Integer idProfession;

    // Constructor vacío
    public ProviderProfessionId() {
    }

    // Constructor con parámetros
    public ProviderProfessionId(Integer idProvider, Integer idProfession) {
        this.idProvider = idProvider;
        this.idProfession = idProfession;
    }

    // Getters y Setters
    public Integer getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Integer idProvider) {
        this.idProvider = idProvider;
    }

    public Integer getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    // Métodos equals y hashCode basados en los campos de la clave compuesta
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        ProviderProfessionId that = (ProviderProfessionId) o;
        return Objects.equals(idProvider, that.idProvider) &&
                Objects.equals(idProfession, that.idProfession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProvider, idProfession);
    }
}
