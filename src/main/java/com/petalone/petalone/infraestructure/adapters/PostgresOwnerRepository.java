package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.PetOwnerAble;
import com.petalone.petalone.aplication.impl.PetOwnerimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetOwnerDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.PetOwner;
import com.petalone.petalone.infraestructure.repositories.PetOwnerRepository;
import com.petalone.petalone.infraestructure.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresOwnerRepository")
@Repository("petownerPersistence")
public class PostgresOwnerRepository implements PetOwnerAble {

    //Conetar base de datos
    @Autowired
    private PetOwnerRepository petOwnerRepository;


    @Override
    public PetOwnerDTO save(PetOwnerDTO petownerDTO) {
        return petOwnerRepository.save(new PetOwner(petownerDTO)).toPetOwnerDto();
    }

    @Override
    public PetOwnerDTO update(PetOwnerDTO petOwnerDTO) throws PetalonException {
        if (petOwnerRepository.existsById(petOwnerDTO.getNumIndentification())) {
            try {
                return
                        petOwnerRepository.save(new PetOwner(petOwnerDTO)).toPetOwnerDto();

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
    public boolean delete(String numIndentification) throws PetalonException {
        if (petOwnerRepository.existsById(numIndentification)) {
            try {
                petOwnerRepository.deleteById(numIndentification);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + numIndentification);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + numIndentification);
        }
    }


    @Override
    public List<PetOwnerDTO> list() {
        List<PetOwner> petowners=petOwnerRepository.findAll();
        List<PetOwnerDTO> petownersDTO= new ArrayList<>();
        for (PetOwner petowner:petowners)
        {
            petownersDTO.add(petowner.toPetOwnerDto());
        }
        return petownersDTO;
    }



}
