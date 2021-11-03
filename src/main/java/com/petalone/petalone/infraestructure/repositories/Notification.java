package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Notification {
    private String idNotification;
    private String name;
    private String typeNotification;
    private Date date;
    private MotionSensor motionSensorByIdMotionSensor;
    private CookiesSensor cookiesSensorByIdCookies;

    @Id
    @Column(name = "id_notification", nullable = false, length = 5)
    public String getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(String idNotification) {
        this.idNotification = idNotification;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 5)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type_notification", nullable = true, length = 5)
    public String getTypeNotification() {
        return typeNotification;
    }

    public void setTypeNotification(String typeNotification) {
        this.typeNotification = typeNotification;
    }

    @Basic
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification that = (Notification) o;
        return Objects.equals(idNotification, that.idNotification) && Objects.equals(name, that.name) && Objects.equals(typeNotification, that.typeNotification) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idNotification, name, typeNotification, date);
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
    @JoinColumn(name = "id_cookies", referencedColumnName = "id")
    public CookiesSensor getCookiesSensorByIdCookies() {
        return cookiesSensorByIdCookies;
    }

    public void setCookiesSensorByIdCookies(CookiesSensor cookiesSensorByIdCookies) {
        this.cookiesSensorByIdCookies = cookiesSensorByIdCookies;
    }
}
