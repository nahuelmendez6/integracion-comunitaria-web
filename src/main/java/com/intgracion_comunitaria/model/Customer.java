package com.integracion_comunitaria.model;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_customer")
    private Integer id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "date_year")
    @Temporal(TemporalType.DATE)
    private Date dateYear;

    @Column(name = "dni", length = 20)
    private String dni;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "adress", length = 50)
    private String address;

    @ManyToOne
    @JoinColumn(name = "id_gender_type", referencedColumnName = "id_gender")
    private String genderType;

    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city")
    private String city;

    @Column(name = "gps_lat", precision = 10, scale = 8)
    private Double gpsLat;

    @Column(name = "gps_lon", precision = 11, scale = 8)
    private Double gpsLon;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "date_create")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    @Column(name = "date_update")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    public Customer(String name, Date dateYear, String dni, String phone, String email, String address,
                    String genderType, String city, Double gpsLat, Double gpsLon, Integer idUserCreate, Integer idUserUpdate, Date dateCreate, Date dateUpdate) {
        this.name = name;
        this.dateYear = dateYear;
        this.dni = dni;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.genderType = genderType;
        this.city = city;
        this.gpsLat = gpsLat;
        this.gpsLon = gpsLon;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Customer() {
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

    public Date getDateYear() {
        return dateYear;
    }

    public void setDateYear(Date dateYear) {
        this.dateYear = dateYear;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(Double gpsLat) {
        this.gpsLat = gpsLat;
    }

    public Double getGpsLon() {
        return gpsLon;
    }

    public void setGpsLon(Double gpsLon) {
        this.gpsLon = gpsLon;
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

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public Date getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(Date dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}