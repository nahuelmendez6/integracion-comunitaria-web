package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.util.Date;


@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider")
    private Integer id;

    @Column(name = "name", length = 45, nullable = false)
    private String name;

    @Column(name = "address", length = 45, nullable = false)
    private String address;

    @Column(name = "gps_lat", nullable = false)
    private Float gpsLat;

    @Column(name = "gps_long", nullable = false)
    private Float gpsLong;

    @ManyToOne
    @JoinColumn(name = "id_type_provider", referencedColumnName = "id_type_provider", foreignKey = @ForeignKey(name = "fk_typeprovider"))
    private String typeProvider;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", foreignKey = @ForeignKey(name = "fk_category"))
    private String category;

    @ManyToOne
    @JoinColumn(name = "id_grade_provider", referencedColumnName = "id_grade_provider", foreignKey = @ForeignKey(name = "fk_grade_provider"))
    private Integer gradeProvider;

    @ManyToOne
    @JoinColumn(name = "id_availability", referencedColumnName = "id_availability", foreignKey = @ForeignKey(name = "fk_availability"))
    private String availability;

    @Column(name = "id_usercreate")
    private Integer idUserCreate;

    @Column(name = "id_userupdate")
    private Integer idUserUpdate;


    public Provider(String name, String address, Float gpsLat, Float gpsLong, String typeProvider, String category,
                    Integer gradeProvider, String availability, Integer idUserCreate, Integer idUserUpdate) {
        this.name = name;
        this.address = address;
        this.gpsLat = gpsLat;
        this.gpsLong = gpsLong;
        this.typeProvider = typeProvider;
        this.category = category;
        this.gradeProvider = gradeProvider;
        this.availability = availability;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
    }

    public Provider() {
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Float gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Float getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(Float gpsLong) {
        this.gpsLong = gpsLong;
    }

    public String getTypeProvider() {
        return typeProvider;
    }

    public void setTypeProvider(String typeProvider) {
        this.typeProvider = typeProvider;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getGradeProvider() {
        return gradeProvider;
    }

    public void setGradeProvider(Integer gradeProvider) {
        this.gradeProvider = gradeProvider;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
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
}