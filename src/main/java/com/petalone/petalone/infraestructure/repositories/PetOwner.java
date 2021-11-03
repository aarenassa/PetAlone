package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_owner", schema = "public", catalog = "petalone1")
public class PetOwner {
    private String numIndentification;
    private String idType;
    private String name;
    private String lastName;
    private String numPhone;
    private String email;
    private Pet petByIdPet;
    private Notification notificationByIdNotification;
    private Camera cameraByIdCamera;

    @Id
    @Column(name = "num_indentification", nullable = false, length = 5)
    public String getNumIndentification() {
        return numIndentification;
    }

    public void setNumIndentification(String numIndentification) {
        this.numIndentification = numIndentification;
    }

    @Basic
    @Column(name = "id_type", nullable = true, length = 15)
    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
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
    @Column(name = "last_name", nullable = true, length = 20)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "num_phone", nullable = true, length = 15)
    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 20)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetOwner petOwner = (PetOwner) o;
        return Objects.equals(numIndentification, petOwner.numIndentification) && Objects.equals(idType, petOwner.idType) && Objects.equals(name, petOwner.name) && Objects.equals(lastName, petOwner.lastName) && Objects.equals(numPhone, petOwner.numPhone) && Objects.equals(email, petOwner.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numIndentification, idType, name, lastName, numPhone, email);
    }

    @ManyToOne
    @JoinColumn(name = "id_pet", referencedColumnName = "id_pet")
    public Pet getPetByIdPet() {
        return petByIdPet;
    }

    public void setPetByIdPet(Pet petByIdPet) {
        this.petByIdPet = petByIdPet;
    }

    @ManyToOne
    @JoinColumn(name = "id_notification", referencedColumnName = "id_notification")
    public Notification getNotificationByIdNotification() {
        return notificationByIdNotification;
    }

    public void setNotificationByIdNotification(Notification notificationByIdNotification) {
        this.notificationByIdNotification = notificationByIdNotification;
    }

    @ManyToOne
    @JoinColumn(name = "id_camera", referencedColumnName = "id_camera")
    public Camera getCameraByIdCamera() {
        return cameraByIdCamera;
    }

    public void setCameraByIdCamera(Camera cameraByIdCamera) {
        this.cameraByIdCamera = cameraByIdCamera;
    }
}
