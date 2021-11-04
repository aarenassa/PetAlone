package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "cookies_sensor", schema = "public", catalog = "petalone1")
public class CookiesSensor {

    @Id
    @Column(name = "id", nullable = false, length = 5)
    private String id;
    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "messagge", nullable = true, length = 30)
    private String messagge;
    @Basic
    @Column(name = "num_serial", nullable = true, length = 50)
    private String numSerial;
    @Basic
    @Column(name = "address_ubication", nullable = true, length = 15)
    private String addressUbication;
    @Basic
    @Column(name = "located_at", nullable = true, length = 15)
    private String locatedAt;
    @Basic
    @Column(name = "num_activity", nullable = true, length = 5)
    private String numActivity;
    @Basic
    @Column(name = "date_activity", nullable = true)
    private Date dateActivity;

}
