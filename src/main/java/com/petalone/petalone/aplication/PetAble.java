package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.PetDTO;

import java.util.List;

public interface PetAble {
    PetDTO save(PetDTO petDTO);
    PetDTO update(PetDTO petDTO);
    boolean delete(String idPet);
    List<PetDTO> list();
}