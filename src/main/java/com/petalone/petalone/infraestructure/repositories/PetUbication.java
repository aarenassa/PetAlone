package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_ubication", schema = "public", catalog = "petalone1")
public class PetUbication {
    private String idUbication;
    private String numIdentification;
    private String nameUbication;
    private String address;
    private String numPhone;
    private Pet petByIdPet;
    private SoundSensor soundSensorByIdSoundSensor;
    private MotionSensor motionSensorByIdMotionSensor;
    private Notification notificationByIdNotification;
    private Camera cameraByIdCamera;
    private InformationInstallation informationInstallationByIdInstallation;
    private CookiesSensor cookiesSensorByIdCookies;

    @Id
    @Column(name = "id_ubication", nullable = false, length = 5)
    public String getIdUbication() {
        return idUbication;
    }

    public void setIdUbication(String idUbication) {
        this.idUbication = idUbication;
    }

    @Basic
    @Column(name = "num_identification", nullable = true, length = 5)
    public String getNumIdentification() {
        return numIdentification;
    }

    public void setNumIdentification(String numIdentification) {
        this.numIdentification = numIdentification;
    }

    @Basic
    @Column(name = "name_ubication", nullable = true, length = 20)
    public String getNameUbication() {
        return nameUbication;
    }

    public void setNameUbication(String nameUbication) {
        this.nameUbication = nameUbication;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 15)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "num_phone", nullable = true, length = 15)
    public String getNumPhone() {
        return numPhone;
    }

    public void setNumPhone(String numPhone) {
        this.numPhone = numPhone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PetUbication that = (PetUbication) o;
        return Objects.equals(idUbication, that.idUbication) && Objects.equals(numIdentification, that.numIdentification) && Objects.equals(nameUbication, that.nameUbication) && Objects.equals(address, that.address) && Objects.equals(numPhone, that.numPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUbication, numIdentification, nameUbication, address, numPhone);
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
    @JoinColumn(name = "id_sound_sensor", referencedColumnName = "id_sensor")
    public SoundSensor getSoundSensorByIdSoundSensor() {
        return soundSensorByIdSoundSensor;
    }

    public void setSoundSensorByIdSoundSensor(SoundSensor soundSensorByIdSoundSensor) {
        this.soundSensorByIdSoundSensor = soundSensorByIdSoundSensor;
    }

    @ManyToOne
    @JoinColumn(name = "id_motion_sensor", referencedColumnName = "id_sensor")
    public MotionSensor getMotionSensorByIdMotionSensor() {
        return motionSensorByIdMotionSensor;
    }

    public void setMotionSensorByIdMotionSensor(MotionSensor motionSensorByIdMotionSensor) {
        this.motionSensorByIdMotionSensor = motionSensorByIdMotionSensor;
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

    @ManyToOne
    @JoinColumn(name = "id_installation", referencedColumnName = "id_installation")
    public InformationInstallation getInformationInstallationByIdInstallation() {
        return informationInstallationByIdInstallation;
    }

    public void setInformationInstallationByIdInstallation(InformationInstallation informationInstallationByIdInstallation) {
        this.informationInstallationByIdInstallation = informationInstallationByIdInstallation;
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
