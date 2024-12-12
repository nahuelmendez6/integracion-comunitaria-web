package com.intgracion_comunitaria.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class TypeJornal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_jornal")
    private Long id_type_jornal;

    @Column(name = "name", length = 70, nullable = false)
    private String name;

    @Column(name = "id_user_create", nullable = false)
    private Integer idUserCreate;

    @Column(name = "id_user_update", nullable = false)
    private Integer idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false)
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;

    public TypeJornal() {
    }

    public TypeJornal(Long id_type_jornal, String name, Integer idUserCreate, Integer idUserUpdate,
            Timestamp dateCreate, Timestamp dateUpdate) {
        this.id_type_jornal = id_type_jornal;
        this.name = name;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getId_type_jornal() {
        return id_type_jornal;
    }

    public String getName() {
        return name;
    }

    public Integer getIdUserCreate() {
        return idUserCreate;
    }

    public Integer getIdUserUpdate() {
        return idUserUpdate;
    }

    public Timestamp getDateCreate() {
        return dateCreate;
    }

    public Timestamp getDateUpdate() {
        return dateUpdate;
    }

    public void setId_type_jornal(Long id_type_jornal) {
        this.id_type_jornal = id_type_jornal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIdUserCreate(Integer idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public void setIdUserUpdate(Integer idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public void setDateCreate(Timestamp dateCreate) {
        this.dateCreate = dateCreate;
    }

    public void setDateUpdate(Timestamp dateUpdate) {
        this.dateUpdate = dateUpdate;
    }

}
