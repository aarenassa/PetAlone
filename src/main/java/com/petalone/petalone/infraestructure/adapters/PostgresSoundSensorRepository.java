package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.SoundSensorAble;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.SoundSensorDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.Pet;
import com.petalone.petalone.infraestructure.repositories.SoudSensorRepository;
import com.petalone.petalone.infraestructure.repositories.SoundSensor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Qualifier("PostgresSoundSensorRepository")
@Repository("soundsensorPersistence")
public class PostgresSoundSensorRepository implements SoundSensorAble {

    @Autowired
    private SoudSensorRepository soudSensorRepository;

    @Override
    public SoundSensorDTO save(SoundSensorDTO soundSensorDTO) {
        return soudSensorRepository.save(new SoundSensor(soundSensorDTO)).tosoundSensorDTo();
    }

    @Override
    public SoundSensorDTO update(SoundSensorDTO soundSensorDTO) throws PetalonException {
        if (soudSensorRepository.existsById(soundSensorDTO.getIdSensor())) {
            try {
                return
                        soudSensorRepository.save(new SoundSensor(soundSensorDTO)).tosoundSensorDTo();
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
    public boolean delete(String idSensor) throws PetalonException {
        if (soudSensorRepository.existsById(idSensor)) {
            try {
                soudSensorRepository.deleteById(idSensor);
                return true;
            }
            catch (Exception e) {
                throw new PetalonException("El codigo tienen dependencia relacionales" + idSensor);
            }
        }
        else {
            throw new PetalonException("Codigo no existe" + idSensor);
        }
    }

    @Override
    public List<SoundSensorDTO> list() {
        List<SoundSensor> soundSensors = soudSensorRepository.findAll();
        List<SoundSensorDTO> soundSensorDTOS= new ArrayList<>();
        for (SoundSensor soundSensor:soundSensors)
        {
            soundSensorDTOS.add(soundSensor.tosoundSensorDTo());
        }
        return soundSensorDTOS;
    }
}
