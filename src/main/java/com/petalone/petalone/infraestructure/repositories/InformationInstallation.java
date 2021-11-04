package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "information_installation", schema = "public", catalog = "petalone1")
public class InformationInstallation {


    @Id
    @Column(name = "id_installation", nullable = false, length = 5)
    private String idInstallation;
    @Basic
    @Column(name = "name_ubication", nullable = true, length = 15)
    private String nameUbication;
    @Basic
    @Column(name = "name_owner", nullable = true, length = 15)
    private String nameOwner;
    @Basic
    @Column(name = "devices", nullable = true, length = 15)
    private String devices;
    @Basic
    @Column(name = "date_installation", nullable = true)
    private Date dateInstallation;
    @Basic
    @Column(name = "who_installed", nullable = true, length = 20)
    private String whoInstalled;

}
