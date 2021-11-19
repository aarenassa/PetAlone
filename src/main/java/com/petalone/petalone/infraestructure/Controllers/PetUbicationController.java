package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.PetUbicationimpl;
import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetUbicationDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "petubication")
@CrossOrigin(origins = "http://localhost:4200")
public class PetUbicationController {
    @Autowired
    private PetUbicationimpl petUbicationimpl;

    // GUARDAR
    @PostMapping(path = "/save_petubication")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid PetUbicationDTO petUbicationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petUbicationimpl.save(petUbicationDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", petUbicationimpl.list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{idUbication}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String idUbication) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", petUbicationimpl.delete(idUbication),null), HttpStatus.OK);
    }


    // ACTUALIZAR
    @PostMapping(path = "/Update_petubication")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid PetUbicationDTO petUbicationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petUbicationimpl
                .save(petUbicationDTO),null), HttpStatus.OK);
    }



}
