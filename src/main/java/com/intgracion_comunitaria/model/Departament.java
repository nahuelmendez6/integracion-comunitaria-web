package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "departament")
public class Departament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_departament")
    private Integer idDepartament;

    @Column(name = "name_departament", length = 40)
    private String nameDepartament;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_country", referencedColumnName = "id_country")
    private Country country;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_province", referencedColumnName = "id_province")
    private Province province;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "data_create", nullable = false)
    private Timestamp dataCreate;

    @Column(name = "data_update", nullable = false)
    private Timestamp dataUpdate;

    // Getters y Setters

    public Integer getIdDepartament() {
        return idDepartament;
    }

    public void setIdDepartament(Integer idDepartament) {
        this.idDepartament = idDepartament;
    }

    public String getNameDepartament() {
        return nameDepartament;
    }

    public void setNameDepartament(String nameDepartament) {
        this.nameDepartament = nameDepartament;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
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

    public Timestamp getDataCreate() {
        return dataCreate;
    }

    public void setDataCreate(Timestamp dataCreate) {
        this.dataCreate = dataCreate;
    }

    public Timestamp getDataUpdate() {
        return dataUpdate;
    }

    public void setDataUpdate(Timestamp dataUpdate) {
        this.dataUpdate = dataUpdate;
    }
}
