package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Camera {
    private String idCamera;
    private String name;
    private String numSerial;
    private String addressUbication;
    private String locatedAt;
    private String ipAddress;

    @Id
    @Column(name = "id_camera", nullable = false, length = 5)
    public String getIdCamera() {
        return idCamera;
    }

    public void setIdCamera(String idCamera) {
        this.idCamera = idCamera;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "num_serial", nullable = true, length = 15)
    public String getNumSerial() {
        return numSerial;
    }

    public void setNumSerial(String numSerial) {
        this.numSerial = numSerial;
    }

    @Basic
    @Column(name = "address_ubication", nullable = true, length = 15)
    public String getAddressUbication() {
        return addressUbication;
    }

    public void setAddressUbication(String addressUbication) {
        this.addressUbication = addressUbication;
    }

    @Basic
    @Column(name = "located_at", nullable = true, length = 15)
    public String getLocatedAt() {
        return locatedAt;
    }

    public void setLocatedAt(String locatedAt) {
        this.locatedAt = locatedAt;
    }

    @Basic
    @Column(name = "ip_address", nullable = true, length = 12)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Camera camera = (Camera) o;
        return Objects.equals(idCamera, camera.idCamera) && Objects.equals(name, camera.name) && Objects.equals(numSerial, camera.numSerial) && Objects.equals(addressUbication, camera.addressUbication) && Objects.equals(locatedAt, camera.locatedAt) && Objects.equals(ipAddress, camera.ipAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCamera, name, numSerial, addressUbication, locatedAt, ipAddress);
    }
}
