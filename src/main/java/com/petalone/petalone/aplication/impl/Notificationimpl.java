package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.NotificationAble;
import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.NotificationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Notificationimpl implements NotificationAble {

    @Autowired
    @Qualifier("PostgresNotificationRepository")
    private NotificationAble notificationPersistence;


    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        return notificationPersistence.save(notificationDTO);
    }

    @Override
    public NotificationDTO update(NotificationDTO notificationDTO) throws PetalonException{
        return notificationPersistence.update(notificationDTO);
    }

    @Override
    public boolean delete(String idNotification) throws PetalonException {
        return notificationPersistence.delete(idNotification);
    }

    @Override
    public List<NotificationDTO> list() {
        return notificationPersistence.list();
    }
}
