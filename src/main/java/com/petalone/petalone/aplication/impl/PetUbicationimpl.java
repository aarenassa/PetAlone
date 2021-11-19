package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.aplication.PetUbicationAble;
import com.petalone.petalone.domain.PetUbicationDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PetUbicationimpl implements PetUbicationAble {

    @Autowired
    @Qualifier("PostgresUbicationRepository")
    private PetUbicationAble petUbicationPersistence;

    @Override
    public PetUbicationDTO save(PetUbicationDTO petUbicationDTO) {
        return petUbicationPersistence.save(petUbicationDTO);
    }

    @Override
    public PetUbicationDTO update(PetUbicationDTO petUbicationDTO) throws PetalonException{
        return petUbicationPersistence.update(petUbicationDTO);
    }

    @Override
    public boolean delete(String idUbication) throws PetalonException {
        return petUbicationPersistence.delete(idUbication);
    }

    @Override
    public List<PetUbicationDTO> list() {
        return petUbicationPersistence.list();
    }
}
