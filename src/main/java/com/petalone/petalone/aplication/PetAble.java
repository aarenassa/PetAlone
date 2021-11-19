package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface PetAble {
    PetDTO save(PetDTO petDTO);
    PetDTO update(PetDTO petDTO) throws PetalonException;
    boolean delete(String id_Pet) throws PetalonException;
    List<PetDTO> list();
}