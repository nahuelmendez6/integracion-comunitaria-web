package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "profession")
public class Profession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profession")
    private Integer idProfession;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Column(name = "date_create", nullable = false, updatable = false)
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false)
    private Timestamp dateUpdate;

    // Constructor sin parámetros
    public Profession() {
    }

    // Constructor con parámetros
    public Profession(String name, Category category) {
        this.name = name;
        this.category = category;
        this.dateCreate = new Timestamp(System.currentTimeMillis());
        this.dateUpdate = new Timestamp(System.currentTimeMillis());
    }

    // Getters y Setters
    public Integer getIdProfession() {
        return idProfession;
    }

    public void setIdProfession(Integer idProfession) {
        this.idProfession = idProfession;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Profession that = (Profession) o;
        return idProfession != null && idProfession.equals(that.idProfession);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "idProfession=" + idProfession +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", dateCreate=" + dateCreate +
                ", dateUpdate=" + dateUpdate +
                '}';
    }
}
