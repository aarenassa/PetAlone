package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cookies_sensor", schema = "public", catalog = "petalone1")
public class CookiesSensor {
    private String id;
    private String name;
    private String messagge;
    private String numSerial;
    private String addressUbication;
    private String locatedAt;
    private String numActivity;
    private Date dateActivity;

    @Id
    @Column(name = "id", nullable = false, length = 5)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    @Column(name = "messagge", nullable = true, length = 30)
    public String getMessagge() {
        return messagge;
    }

    public void setMessagge(String messagge) {
        this.messagge = messagge;
    }

    @Basic
    @Column(name = "num_serial", nullable = true, length = 50)
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
    @Column(name = "num_activity", nullable = true, length = 5)
    public String getNumActivity() {
        return numActivity;
    }

    public void setNumActivity(String numActivity) {
        this.numActivity = numActivity;
    }

    @Basic
    @Column(name = "date_activity", nullable = true)
    public Date getDateActivity() {
        return dateActivity;
    }

    public void setDateActivity(Date dateActivity) {
        this.dateActivity = dateActivity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CookiesSensor that = (CookiesSensor) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(messagge, that.messagge) && Objects.equals(numSerial, that.numSerial) && Objects.equals(addressUbication, that.addressUbication) && Objects.equals(locatedAt, that.locatedAt) && Objects.equals(numActivity, that.numActivity) && Objects.equals(dateActivity, that.dateActivity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, messagge, numSerial, addressUbication, locatedAt, numActivity, dateActivity);
    }
}
