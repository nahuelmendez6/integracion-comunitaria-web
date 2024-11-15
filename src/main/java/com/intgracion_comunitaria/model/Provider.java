package com.intgracion_comunitaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "provider")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_provider", nullable = false)
    private Long idProvider;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_provider", referencedColumnName = "id_type_provider", foreignKey = @ForeignKey(name = "fk_typeprovider"))
    private TypeProvider typeProvider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_category", referencedColumnName = "id_category", foreignKey = @ForeignKey(name = "fk_category"))
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grade_provider", referencedColumnName = "id_grade_provider", foreignKey = @ForeignKey(name = "fk_grade_provider"))
    private GradeProvider gradeProvider;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_availability", referencedColumnName = "id_availability", foreignKey = @ForeignKey(name = "fk_availability"))
    private Availability availability;

    @Column(name = "id_usercreate")
    private Integer idUserCreate;

    @Column(name = "id_userupdate")
    private Integer idUserUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_adress", referencedColumnName = "id_address", foreignKey = @ForeignKey(name = "fk_id_adress_provider"))
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", foreignKey = @ForeignKey(name = "fk_id_user"))
    private User user;

    // Getters y Setters
    public Long getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(Long idProvider) {
        this.idProvider = idProvider;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeProvider getTypeProvider() {
        return typeProvider;
    }

    public void setTypeProvider(TypeProvider typeProvider) {
        this.typeProvider = typeProvider;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public GradeProvider getGradeProvider() {
        return gradeProvider;
    }

    public void setGradeProvider(GradeProvider gradeProvider) {
        this.gradeProvider = gradeProvider;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
