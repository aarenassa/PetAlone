package com.petalone.petalone.infraestructure.Controllers;


import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "petalon")
@CrossOrigin(origins = "http://localhost:4200")
public class PetController {

    @Autowired
    private Petimpl petimpl;

    // GUARDAR
    @PostMapping(path = "/save_pet")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid PetDTO petDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petimpl.save(petDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", petimpl.list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{id_pet}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String id_pet) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", petimpl.delete(id_pet),null), HttpStatus.OK);
    }


    // ACTUALIZAR
    @PostMapping(path = "/Update_pet")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid PetDTO petDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petimpl
                .save(petDTO),null), HttpStatus.OK);
    }


    // TESTEAR
    @PostMapping("test/call")
    public @ResponseBody ResponseEntity<ResponseDTO> testCommunication(@PathVariable String call)
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction","Prueba"+call,null), HttpStatus.OK);
    }



    public Petimpl getPetimpl() {
        return petimpl;
    }
}
