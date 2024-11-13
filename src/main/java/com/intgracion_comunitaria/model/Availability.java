package com.intgracion_comunitaria.model;


import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_availability")
    private Integer id;

    @Column(name = "id_from_hour", length = 11)
    private String fromHour;

    @Column(name = "id_until_hour", length = 11)
    private String untilHour;

    @ManyToOne
    @JoinColumn(name = "id_week", referencedColumnName = "id_week", foreignKey = @ForeignKey(name = "week"))
    private Integer week;

    @ManyToOne
    @JoinColumn(name = "id_provider", referencedColumnName = "id_provider", foreignKey = @ForeignKey(name = "provider"))
    private Provider provider;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false)
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;

    public Availability(String fromHour, String untilHour, Integer week, Provider provider, Integer idUserCreate,
                        Integer idUserUpdate, Timestamp dateCreate, Timestamp dateUpdate) {
        this.fromHour = fromHour;
        this.untilHour = untilHour;
        this.week = week;
        this.provider = provider;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Availability() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getUntilHour() {
        return untilHour;
    }

    public void setUntilHour(String untilHour) {
        this.untilHour = untilHour;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
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

