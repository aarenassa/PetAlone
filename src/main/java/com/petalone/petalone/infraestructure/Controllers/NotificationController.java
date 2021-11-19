package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.Notificationimpl;
import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.NotificationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "notification")
@CrossOrigin(origins = "http://localhost:4200")
public class NotificationController {
    @Autowired
    private Notificationimpl notificationimpl;

    // GUARDAR
    @PostMapping(path = "/save_notification")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid NotificationDTO notificationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", notificationimpl.save(notificationDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", notificationimpl.list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{idNotification}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String idNotification) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", notificationimpl.delete(idNotification),null), HttpStatus.OK);
    }


    // ACTUALIZAR
    @PostMapping(path = "/Update_notification")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid NotificationDTO notificationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", notificationimpl
                .save(notificationDTO),null), HttpStatus.OK);
    }

}
