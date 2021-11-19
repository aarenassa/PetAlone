package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.NotificationAble;
import com.petalone.petalone.domain.NotificationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.Notification;
import com.petalone.petalone.infraestructure.repositories.NotificationRepository;
import com.petalone.petalone.infraestructure.repositories.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresNotificationRepository")
@Repository("notificationPersistence")
public class PostgresNotificationRepository implements NotificationAble {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        return notificationRepository.save(new Notification(notificationDTO)).toNotificationDTO();
    }

    @Override
    public NotificationDTO update(NotificationDTO notificationDTO) throws PetalonException {
        if (notificationRepository.existsById(notificationDTO.getIdNotification())) {
            try {
                return
                        notificationRepository.save(new Notification(notificationDTO)).toNotificationDTO();

            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales lo que impide actualizar");
            }
        }
        else {
            throw new PetalonException("Codigo no existe lo que impide actualizar");
        }

    }

    @Override
    public boolean delete(String idNotification) throws PetalonException {
        if (notificationRepository.existsById(idNotification)) {
            try {
                notificationRepository.deleteById(idNotification);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + idNotification);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + idNotification);
        }
    }

    @Override
    public List<NotificationDTO> list() {
        List<Notification> notifications=notificationRepository.findAll();
        List<NotificationDTO> notificationDTOS= new ArrayList<>();
        for (Notification notification:notifications)
        {
            notificationDTOS.add(notification.toNotificationDTO());
        }
        return notificationDTOS;
    }
}
