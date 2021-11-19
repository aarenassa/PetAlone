package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.CookiesSensorAble;
import com.petalone.petalone.domain.CookiesSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.CookiesSensor;
import com.petalone.petalone.infraestructure.repositories.CookiesSensorRepository;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresCookiesRepository")
@Repository("coockiesPersistence")
public class PostgresCookiesRepository implements CookiesSensorAble {

    @Autowired
    private CookiesSensorRepository cookiesSensorRepository;


    @Override
    public CookiesSensorDTO save(CookiesSensorDTO cookiesSensorDTO) {
        return cookiesSensorRepository.save(new CookiesSensor(cookiesSensorDTO)).toCookiesSensorDTO();
    }

    @Override
    public CookiesSensorDTO update(CookiesSensorDTO cookiesSensorDTO) throws PetalonException {
        if (cookiesSensorRepository.existsById(cookiesSensorDTO.getId())) {
            try {
                return
                        cookiesSensorRepository.save(new CookiesSensor(cookiesSensorDTO)).toCookiesSensorDTO();

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
    public boolean delete(String id) throws PetalonException {
        if (cookiesSensorRepository.existsById(id)) {
            try {
                cookiesSensorRepository.deleteById(id);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + id);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + id);
        }
    }

    @Override
    public List<CookiesSensorDTO> list() {
        List<CookiesSensor> cookiesSensors=cookiesSensorRepository.findAll();
        List<CookiesSensorDTO> cookiesSensorDTOS= new ArrayList<>();
        for (CookiesSensor cookiesSensor:cookiesSensors)
        {
            cookiesSensorDTOS.add(cookiesSensor.toCookiesSensorDTO());
        }
        return cookiesSensorDTOS;
    }
}
