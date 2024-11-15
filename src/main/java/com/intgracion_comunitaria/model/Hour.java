package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "hour")
public class Hour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hour")
    private Integer idHour;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_week", nullable = false)
    private Week week;

    @Column(name = "id_user_create", length = 45)
    private String idUserCreate;

    @Column(name = "id_user_update", length = 45)
    private String idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false)
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;

    // Getters and Setters

    public Integer getIdHour() {
        return idHour;
    }

    public void setIdHour(Integer idHour) {
        this.idHour = idHour;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Week getWeek() {
        return week;
    }

    public void setWeek(Week week) {
        this.week = week;
    }

    public String getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(String idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public String getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(String idUserUpdate) {
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
