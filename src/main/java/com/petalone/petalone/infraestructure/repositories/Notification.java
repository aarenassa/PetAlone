package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.NotificationDTO;
import com.petalone.petalone.domain.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Notification {

    @Id
    @Column(name = "id_notification", nullable = false)
    private String idNotification;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;
    @Basic
    @Column(name = "type_notification", nullable = true)
    private String typeNotification;
    @Basic
    @Column(name = "date", nullable = true)
    private Date date;

    public Notification(NotificationDTO notificationDTO) {
        BeanUtils.copyProperties(notificationDTO, this);
        this.idNotification = java.util.UUID.randomUUID().toString();
    }

    public NotificationDTO toNotificationDTO()
    {
        NotificationDTO notificationDTO=new NotificationDTO();
        BeanUtils.copyProperties( this,notificationDTO);
        return notificationDTO;
    }
}
