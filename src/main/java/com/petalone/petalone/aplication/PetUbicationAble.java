package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetUbicationDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface PetUbicationAble {
    PetUbicationDTO save(PetUbicationDTO petUbicationDTO);
    PetUbicationDTO update(PetUbicationDTO petUbicationDTO) throws PetalonException;
    boolean delete(String idUbication) throws PetalonException;
    List<PetUbicationDTO> list();
}
