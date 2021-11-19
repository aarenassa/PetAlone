package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.PetOwnerimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetOwnerDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(path = "petowner")
@CrossOrigin(origins = "http://localhost:4200")
public class PetOwnerController {

    @Autowired
    private PetOwnerimpl petownerimpl;

    //GUARDAR
    @PostMapping(path = "/save_Owner")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid PetOwnerDTO petownerDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petownerimpl.save(petownerDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", petownerimpl.list(),null), HttpStatus.OK);
    }

    //ELIMINAR
    @DeleteMapping("{numIndentification}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String numIndentification) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", petownerimpl.delete(numIndentification),null), HttpStatus.OK);
    }


    //ACTUALIZAR
    @PostMapping(path = "/Update_petowner")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid PetOwnerDTO petOwnerDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petownerimpl
                .save(petOwnerDTO),null), HttpStatus.OK);
    }


}
