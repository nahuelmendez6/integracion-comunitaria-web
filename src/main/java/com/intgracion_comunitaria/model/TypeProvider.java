package com.intgracion_comunitaria.model;


import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "type_provider")
public class TypeProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_provider")
    private Integer id;

    @Column(name = "type", length = 70, nullable = false)
    private String type;

    @Column(name = "business")
    private Boolean business;

    @Column(name = "transport")
    private Boolean transport;

    @Column(name = "id_user_create", nullable = false)
    private Integer idUserCreate;

    @Column(name = "id_user_update", nullable = false)
    private Integer idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false)
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;

    public TypeProvider(String type, Boolean business, Boolean transport, Integer idUserCreate, Integer idUserUpdate,
                        Timestamp dateCreate, Timestamp dateUpdate) {
        this.type = type;
        this.business = business;
        this.transport = transport;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public TypeProvider() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getBusiness() {
        return business;
    }

    public void setBusiness(Boolean business) {
        this.business = business;
    }

    public Boolean getTransport() {
        return transport;
    }

    public void setTransport(Boolean transport) {
        this.transport = transport;
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
