package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class Petimpl implements PetAble {


    @Autowired
    @Qualifier("PostgresPetRepository")
    private PetAble petPersistence;

    @Override
    public PetDTO save(PetDTO petDTO) { return petPersistence.save(petDTO); }

    @Override
    public PetDTO update(PetDTO petDTO) throws PetalonException {
        return petPersistence.update(petDTO);
    }

    @Override
    public boolean delete(String id_Pet) throws PetalonException
    { return petPersistence.delete(id_Pet); }

    @Override
    public List<PetDTO> list() { return petPersistence.list(); }

}
