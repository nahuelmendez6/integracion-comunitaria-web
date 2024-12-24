package com.intgracion_comunitaria.model;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "attachment_portfolio")
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

    @Column(name = "id_user_create", nullable = true)
    private Integer idUserCreate;

    @Column(name = "id_user_update", nullable = true)
    private Integer idUserUpdate;

    @Column(name = "date_create")
    @Temporal(TemporalType.DATE)
    private Date dateCreate;

    @Column(name = "date_update")
    @Temporal(TemporalType.DATE)
    private Date dateUpdate;

    @Column(name = "file_type")
    private String filetype;

    public Attachment() {
    }

    public Attachment(Long idAttachment, Portfolio portfolio, String name, String path, Integer idUserCreate,
            Integer idUserUpdate, Date dateCreate, Date dateUpdate, String filetype) {
        this.idAttachment = idAttachment;
        this.portfolio = portfolio;
        this.name = name;
        this.path = path;
        this.idUserCreate = idUserCreate;
        this.idUserUpdate = idUserUpdate;
        this.dateCreate = dateCreate;
        this.dateUpdate = dateUpdate;
        this.filetype = filetype;
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

    public String getFileType() {
        return filetype;
    }

    public void setFileType(String fileType) {
        this.filetype = fileType;
    }

    // Getters y setters

}
