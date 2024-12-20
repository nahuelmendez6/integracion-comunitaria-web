package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attachment")
    private Long idAttachment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_portfolio", nullable = false)
    private Portfolio portfolio;

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @Column(name = "path", nullable = false, length = 4000)
    private String path;

    @Column(name = "id_user_create", nullable = false)
    private Integer idUserCreate;

    @Column(name = "id_user_update", nullable = false)
    private Integer idUserUpdate;

    @Column(name = "date_create")
    private LocalDateTime dateCreate = LocalDateTime.now();

    @Column(name = "date_update")
    private LocalDateTime dateUpdate = LocalDateTime.now();

    public Attachment() {
    }

    public Attachment(Long idAttachment, Portfolio portfolio, String name, String path, Integer idUserCreate,
            Integer idUserUpdate, LocalDateTime dateCreate, LocalDateTime dateUpdate) {
        this.idAttachment = idAttachment;
        this.portfolio = portfolio;
        this.name = name;
        this.path = path;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
    }

    public Long getIdAttachment() {
        return idAttachment;
    }

    public void setIdAttachment(Long idAttachment) {
        this.idAttachment = idAttachment;
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

    // Getters y setters

}
