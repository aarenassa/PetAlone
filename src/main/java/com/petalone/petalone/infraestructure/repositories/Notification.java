package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Notification {

    @Id
    @Column(name = "id_notification", nullable = false, length = 5)
    private String idNotification;
    @Basic
    @Column(name = "name", nullable = true, length = 5)
    private String name;
    @Basic
    @Column(name = "type_notification", nullable = true, length = 5)
    private String typeNotification;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;

}
