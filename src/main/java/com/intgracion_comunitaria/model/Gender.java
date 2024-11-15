package com.intgracion_comunitaria.model;

import jakarta.persistence.*;

import java.security.Timestamp;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_gender")
    private Integer id;

    @Column(name = "gender", length = 40)
    private String gender;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "data_crate", nullable = false, updatable = false)
    private Timestamp dataCreate;

    @Column(name = "data_update", nullable = false)
    private Timestamp dataUpdate;

    public Gender(String gender, Integer idUserCreate, Integer idUserUpdate, Timestamp dataCreate,
            Timestamp dataUpdate) {
        this.gender = gender;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dataCreate = dataCreate;
        this.dataUpdate = dataUpdate;
    }

    public Gender() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
