package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
    public PetDTO update(PetDTO petDTO) {
         return petRepository.save(new Pet(petDTO)).toPetDto();
    }

    @Override
    public boolean delete(String idPet) {
        petRepository.deleteById(idPet);
        return true;

    }

    @Override
    public List<PetDTO> list() {
        return null;
    }


}
