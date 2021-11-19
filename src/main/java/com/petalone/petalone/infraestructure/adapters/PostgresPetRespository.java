package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresPetRepository")
@Repository("petPersistence")

public class PostgresPetRespository implements PetAble {

    //Conetar base de datos
    @Autowired
    private PetRepository petRepository;

    @Override
    public PetDTO save(PetDTO petDTO) {
        return petRepository.save(new Pet(petDTO)).toPetDto();
    }

    @Override
    public PetDTO update(PetDTO petDTO) throws PetalonException {
        if (petRepository.existsById(petDTO.getId_pet())) {
            try {
                return
                petRepository.save(new Pet(petDTO)).toPetDto();

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
    public boolean delete(String id_pet) throws PetalonException {
        if (petRepository.existsById(id_pet)) {
            try {
                petRepository.deleteById(id_pet);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + id_pet + "lo que impide eliminar");
            }
        }
        else {
                throw new PetalonException("Codigo no existe" + id_pet + "lo que impide eliminar");
        }
    }


    @Override
    public List<PetDTO> list() {
        List<Pet> pets=petRepository.findAll();
        List<PetDTO> petsDTO= new ArrayList<>();
        for (Pet pet:pets)
        {
            petsDTO.add(pet.toPetDto());
        }
        return petsDTO;
    }


}
