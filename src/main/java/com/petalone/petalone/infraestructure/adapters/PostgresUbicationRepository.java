package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.PetUbicationAble;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetUbicationDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.PetUbication;
import com.petalone.petalone.infraestructure.repositories.PetUbicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresUbicationRepository")
@Repository("petubicationPersistence")
public class PostgresUbicationRepository implements PetUbicationAble {

    @Autowired
    private PetUbicationRepository petUbicationRepository;

    @Override
    public PetUbicationDTO save(PetUbicationDTO petUbicationDTO) {
        return petUbicationRepository.save(new PetUbication(petUbicationDTO)).topetUbicationDto(); }

    @Override
    public PetUbicationDTO update(PetUbicationDTO petUbicationDTO) throws PetalonException {
        if (petUbicationRepository.existsById(petUbicationDTO.getIdUbication())) {
            try {
                return
                        petUbicationRepository.save(new PetUbication(petUbicationDTO)).topetUbicationDto();

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
    public boolean delete(String idUbication) throws PetalonException {
        if (petUbicationRepository.existsById(idUbication)) {
            try {
                petUbicationRepository.deleteById(idUbication);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + idUbication);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + idUbication);
        }
    }

    @Override
    public List<PetUbicationDTO> list() {
        List<PetUbication> petUbications=petUbicationRepository.findAll();
        List<PetUbicationDTO> petUbicationDTOS= new ArrayList<>();
        for (PetUbication petUbication:petUbications)
        {
            petUbicationDTOS.add(petUbication.topetUbicationDto());
        }
        return petUbicationDTOS;
    }
}
