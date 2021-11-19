package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.MotionSensorimpl;
import com.petalone.petalone.domain.MotionSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "motionsensor")
@CrossOrigin(origins = "http://localhost:4200")
public class MotionSensorController {

    @Autowired
    private MotionSensorimpl motionSensorimpl;

    // GUARDAR
    @PostMapping(path = "/save_motionsensor")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid MotionSensorDTO motionSensorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes",
                motionSensorimpl.save(motionSensorDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success",
                motionSensorimpl.list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{idSensor}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String idSensor) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction",
                        motionSensorimpl.delete(idSensor),null), HttpStatus.OK);
    }

    //ACTUALIZAR
    @PostMapping(path = "/Update_motionsensor")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid MotionSensorDTO motionSensorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", motionSensorimpl
                .save(motionSensorDTO),null), HttpStatus.OK);
    }
}
