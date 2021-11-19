package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.InformationInstallationAble;
import com.petalone.petalone.domain.InformationInstallationDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class InformationInstallationimpl implements InformationInstallationAble{

    @Autowired
    @Qualifier("PostgresInformationInstallationRepository")
    private InformationInstallationAble informationInstallationAble;

    @Override
    public InformationInstallationDTO save(InformationInstallationDTO informationInstallationDTO) {
        return informationInstallationAble.save(informationInstallationDTO);
    }

    @Override
    public InformationInstallationDTO update(InformationInstallationDTO informationInstallationDTO) throws PetalonException{
        return informationInstallationAble.save(informationInstallationDTO);
    }

    @Override
    public boolean delete(String idInstallation) throws PetalonException {
        return informationInstallationAble.delete(idInstallation);
    }

    @Override
    public List<InformationInstallationDTO> list() {
        return informationInstallationAble.list(); }
}
