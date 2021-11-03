package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "information_installation", schema = "public", catalog = "petalone1")
public class InformationInstallation {
    private String idInstallation;
    private String nameUbication;
    private String nameOwner;
    private String devices;
    private Date dateInstallation;
    private String whoInstalled;
    private Camera cameraByIdCamera;
    private CookiesSensor cookiesSensorByIdCookies;

    @Id
    @Column(name = "id_installation", nullable = false, length = 5)
    public String getIdInstallation() {
        return idInstallation;
    }

    public void setIdInstallation(String idInstallation) {
        this.idInstallation = idInstallation;
    }

    @Basic
    @Column(name = "name_ubication", nullable = true, length = 15)
    public String getNameUbication() {
        return nameUbication;
    }

    public void setNameUbication(String nameUbication) {
        this.nameUbication = nameUbication;
    }

    @Basic
    @Column(name = "name_owner", nullable = true, length = 15)
    public String getNameOwner() {
        return nameOwner;
    }

    public void setNameOwner(String nameOwner) {
        this.nameOwner = nameOwner;
    }

    @Basic
    @Column(name = "devices", nullable = true, length = 15)
    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices;
    }

    @Basic
    @Column(name = "date_installation", nullable = true)
    public Date getDateInstallation() {
        return dateInstallation;
    }

    public void setDateInstallation(Date dateInstallation) {
        this.dateInstallation = dateInstallation;
    }

    @Basic
    @Column(name = "who_installed", nullable = true, length = 20)
    public String getWhoInstalled() {
        return whoInstalled;
    }

    public void setWhoInstalled(String whoInstalled) {
        this.whoInstalled = whoInstalled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InformationInstallation that = (InformationInstallation) o;
        return Objects.equals(idInstallation, that.idInstallation) && Objects.equals(nameUbication, that.nameUbication) && Objects.equals(nameOwner, that.nameOwner) && Objects.equals(devices, that.devices) && Objects.equals(dateInstallation, that.dateInstallation) && Objects.equals(whoInstalled, that.whoInstalled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInstallation, nameUbication, nameOwner, devices, dateInstallation, whoInstalled);
    }

    @ManyToOne
    @JoinColumn(name = "id_camera", referencedColumnName = "id_camera")
    public Camera getCameraByIdCamera() {
        return cameraByIdCamera;
    }

    public void setCameraByIdCamera(Camera cameraByIdCamera) {
        this.cameraByIdCamera = cameraByIdCamera;
    }

    @ManyToOne
    @JoinColumn(name = "id_cookies", referencedColumnName = "id")
    public CookiesSensor getCookiesSensorByIdCookies() {
        return cookiesSensorByIdCookies;
    }

    public void setCookiesSensorByIdCookies(CookiesSensor cookiesSensorByIdCookies) {
        this.cookiesSensorByIdCookies = cookiesSensorByIdCookies;
    }
}
