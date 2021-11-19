package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.InformationInstallationAble;
import com.petalone.petalone.domain.InformationInstallationDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.InformationInstallation;
import com.petalone.petalone.infraestructure.repositories.InformationInstallationRepository;
import com.petalone.petalone.infraestructure.repositories.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresInformationInstallationRepository")
@Repository("informationInstallationPersistence")
public class PostgresInformationInstallationRepository implements InformationInstallationAble {


    @Autowired
    private InformationInstallationRepository informationInstallationRepository;

    @Override
    public InformationInstallationDTO save(InformationInstallationDTO informationInstallationDTO) {
        return informationInstallationRepository
                .save(new InformationInstallation(informationInstallationDTO))
                .toinformationInstallationDTO();
    }

    @Override
    public InformationInstallationDTO update(InformationInstallationDTO informationInstallationDTO) throws PetalonException {
        if (informationInstallationRepository.existsById(informationInstallationDTO.getIdInstallation())) {
            try {
                return
                        informationInstallationRepository
                                .save(new InformationInstallation(informationInstallationDTO))
                                .toinformationInstallationDTO();

            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales lo que impide actualizar");
            }
        }
        else {
            throw new PetalonException("Codigo no existe lo que impide actualizar");
        }

    }

    @Override
    public boolean delete(String idInstallation) throws PetalonException {
        if (informationInstallationRepository.existsById(idInstallation)) {
            try {
                informationInstallationRepository.deleteById(idInstallation);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + idInstallation);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + idInstallation);
        }
    }

    @Override
    public List<InformationInstallationDTO> list() {
        List<InformationInstallation> informationInstallations=informationInstallationRepository.findAll();
        List<InformationInstallationDTO> informationInstallationDTOS= new ArrayList<>();
        for (InformationInstallation informationInstallation:informationInstallations)
        {
            informationInstallationDTOS.add(informationInstallation.toinformationInstallationDTO());
        }
        return informationInstallationDTOS;
    }
}
