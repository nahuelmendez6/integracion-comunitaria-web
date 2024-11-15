package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_profile")
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profile")
    private Integer idProfile;

    @Column(name = "email", length = 150)
    private String email;

    @Column(name = "is_admin", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean isAdmin;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", columnDefinition = "ENUM('cliente', 'proveedor', 'ambos') DEFAULT 'cliente'")
    private RoleType roleType;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id_user", nullable = false)
    private User user;

    @Column(name = "id_user_create")
    private Integer idUserCreate;

    @Column(name = "id_user_update")
    private Integer idUserUpdate;

    @Column(name = "date_create", nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dateCreate;

    @Column(name = "date_update", nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Timestamp dateUpdate;

    // Enum para los tipos de rol
    public enum RoleType {
        CLIENTE, PROVEEDOR, AMBOS
    }

    // Getters y Setters

    public Integer getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(Integer idProfile) {
        this.idProfile = idProfile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
