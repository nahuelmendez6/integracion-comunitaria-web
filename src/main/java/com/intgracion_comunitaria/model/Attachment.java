package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attachment")
    private Integer idAttachment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_petition", referencedColumnName = "id_petition", nullable = false)
    private Petition petition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_portfolio", referencedColumnName = "id_portfolio", nullable = false)
    private Portfolio portfolio;

    @Column(name = "name", length = 255, nullable = false)
    private String name;

    @Column(name = "path", length = 4000, nullable = false)
    private String path;

    @Column(name = "id_user_update", nullable = false)
    private Integer idUserUpdate;

    @Column(name = "id_user_create", nullable = false)
    private Integer idUserCreate;

    @Column(name = "date_create", nullable = false, updatable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime dateCreate;

    @Column(name = "date_update", nullable = false, insertable = false, columnDefinition = "DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime dateUpdate;

    // Getters y Setters

    public Integer getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(Integer idAttachment) {
        this.idAttachment = idAttachment;
    }

    public Petition getPetition() {
        return petition;
    }

    public void setPetition(Petition petition) {
        this.petition = petition;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public void setPortfolio(Portfolio portfolio) {
        this.portfolio = portfolio;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getIdUserUpdate() {
        return idUserUpdate;
    }

    public void setIdUserUpdate(Integer idUserUpdate) {
        this.idUserUpdate = idUserUpdate;
    }

    public Integer getIdUserCreate() {
        return idUserCreate;
    }

    public void setIdUserCreate(Integer idUserCreate) {
        this.idUserCreate = idUserCreate;
    }

    public LocalDateTime getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDateTime dateCreate) {
        this.dateCreate = dateCreate;
    }

    public LocalDateTime getDateUpdate() {
        return dateUpdate;
    }

    public void setDateUpdate(LocalDateTime dateUpdate) {
        this.dateUpdate = dateUpdate;
    }
}
