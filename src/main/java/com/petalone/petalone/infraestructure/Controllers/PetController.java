package com.petalone.petalone.infraestructure.Controllers;


import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "petalon")
public class PetController {

    @Autowired
    private Petimpl petimpl;

    @PostMapping(path = "/save_pet")
    public @ResponseBody
    ResponseEntity<ResponseDTO> save(@RequestBody @Valid PetDTO petDTO)
    {
        return new ResponseEntity<>(new ResponseDTO("Succes", petimpl.save(petDTO),null), HttpStatus.OK);
    }
}
