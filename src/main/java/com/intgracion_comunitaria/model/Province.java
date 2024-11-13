package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "province")
public class Province {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_province")
    private Integer idProvince;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    private Country country;

    @Column(name = "mendoza")
    private Boolean mendoza;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp dateUpdate;

    // Getters y Setters

    public Integer getIdProvince() {
        return idProvince;
    }

    public void setIdProvince(Integer idProvince) {
        this.idProvince = idProvince;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Boolean getMendoza() {
        return mendoza;
    }

    public void setMendoza(Boolean mendoza) {
        this.mendoza = mendoza;
    }

    public Integer getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(Integer idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public Integer getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Integer idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
