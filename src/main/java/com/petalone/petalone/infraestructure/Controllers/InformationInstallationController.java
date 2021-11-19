package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.InformationInstallationimpl;
import com.petalone.petalone.domain.InformationInstallationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "Information")
@CrossOrigin(origins = "http://localhost:4200")
public class InformationInstallationController {

    @Autowired
    private InformationInstallationimpl informationInstallationimpl;

    // GUARDAR
    @PostMapping(path = "/save_information")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid InformationInstallationDTO informationInstallationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", informationInstallationimpl
                .save(informationInstallationDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", informationInstallationimpl
                .list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{idInformation}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String idInformation) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", informationInstallationimpl
                        .delete(idInformation),null), HttpStatus.OK);
    }

    @PostMapping(path = "/Update_information")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid InformationInstallationDTO informationInstallationDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", informationInstallationimpl
                .save(informationInstallationDTO),null), HttpStatus.OK);
    }

}
