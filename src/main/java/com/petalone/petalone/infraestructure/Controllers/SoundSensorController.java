package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.SoundSensorimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.SoundSensorDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "SoundSensor")
@CrossOrigin(origins = "http://localhost:4200")
public class SoundSensorController {


    @Autowired
    private SoundSensorimpl soundSensorimpl;

    // GUARDAR
    @PostMapping(path = "/save_SoundSensor")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid SoundSensorDTO soundSensorDTO)
    {
        return new ResponseEntity<>
                (new ResponseDTO("Succes", soundSensorimpl.save(soundSensorDTO),null),
                        HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>
                (new ResponseDTO("Success", soundSensorimpl.list(),null),
                        HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{idSensor}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String idSensor) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", soundSensorimpl.delete(idSensor),null), HttpStatus.OK);
    }


    // ACTUALIZAR
    @PostMapping(path = "/Update_sound")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid SoundSensorDTO soundSensorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", soundSensorimpl
                .save(soundSensorDTO),null), HttpStatus.OK);
    }


}
