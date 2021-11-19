package com.petalone.petalone.aplication;



import com.petalone.petalone.domain.PetOwnerDTO;
import com.petalone.petalone.exeption.PetalonException;


import java.util.List;

public interface PetOwnerAble {

    PetOwnerDTO save(PetOwnerDTO petownerDTO);
    PetOwnerDTO update(PetOwnerDTO petownerDTO) throws PetalonException;
    boolean delete(String numIndentification) throws PetalonException;
    List<PetOwnerDTO> list();
}
