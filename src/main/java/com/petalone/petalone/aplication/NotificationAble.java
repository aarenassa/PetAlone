package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.NotificationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface NotificationAble {
    NotificationDTO save(NotificationDTO notificationDTO);
    NotificationDTO update(NotificationDTO notificationDTO) throws PetalonException;
    boolean delete(String idNotification) throws PetalonException;
    List<NotificationDTO> list();
}
