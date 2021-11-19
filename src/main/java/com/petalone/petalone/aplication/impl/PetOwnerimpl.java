package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.aplication.PetOwnerAble;
import com.petalone.petalone.domain.PetOwnerDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetOwnerimpl implements PetOwnerAble {

    @Autowired
    @Qualifier("PostgresOwnerRepository")
    private PetOwnerAble petownerPersistence;

    @Override
    public PetOwnerDTO save(PetOwnerDTO petownerDTO) {
        return petownerPersistence.save(petownerDTO);
    }

    @Override
    public PetOwnerDTO update(PetOwnerDTO petownerDTO) {
        return null;
    }

    @Override
    public boolean delete(String numIndentification) throws PetalonException { return petownerPersistence.delete(numIndentification); }

    @Override
    public List<PetOwnerDTO> list() {
        return petownerPersistence.list();
    }
}
