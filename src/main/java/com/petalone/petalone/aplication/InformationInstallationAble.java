package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.InformationInstallationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface InformationInstallationAble {
    InformationInstallationDTO save(InformationInstallationDTO informationInstallationDTO);
    InformationInstallationDTO update(InformationInstallationDTO informationInstallationDTO) throws PetalonException;
    boolean delete(String idInstallation) throws PetalonException;
    List<InformationInstallationDTO> list();
}
