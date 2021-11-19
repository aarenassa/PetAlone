package com.petalone.petalone.infraestructure.Controllers;

import com.petalone.petalone.aplication.impl.CookiesSensorimpl;
import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.CookiesSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "cookiesSensor")
@CrossOrigin(origins = "http://localhost:4200")
public class CookiesSensorController {

    @Autowired
    private CookiesSensorimpl cookiesSensorimpl;

    // GUARDAR
    @PostMapping(path = "/save_cookies")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid CookiesSensorDTO cookiesSensorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", cookiesSensorimpl.save(cookiesSensorDTO),null), HttpStatus.OK);
    }

    // LISTAR
    @GetMapping
    public @ResponseBody ResponseEntity<ResponseDTO> list()
    {
        return new ResponseEntity<>(new ResponseDTO("Success", cookiesSensorimpl.list(),null), HttpStatus.OK);
    }

    // ELIMINAR
    @DeleteMapping("{id}")
    public @ResponseBody ResponseEntity<ResponseDTO> delete(@PathVariable String id) throws PetalonException
    {
        return new ResponseEntity<ResponseDTO>(
                new ResponseDTO("Satisfaction", cookiesSensorimpl.delete(id),null), HttpStatus.OK);
    }


    // ACTUALIZAR
    @PostMapping(path = "/Update_cookies")
    public @ResponseBody
    ResponseEntity<ResponseDTO> update(@RequestBody @Valid CookiesSensorDTO cookiesSensorDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", cookiesSensorimpl
                .save(cookiesSensorDTO),null), HttpStatus.OK);
    }


}
