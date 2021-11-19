package com.petalone.petalone.infraestructure.adapters;

import com.petalone.petalone.aplication.MotionSensorAble;
import com.petalone.petalone.domain.MotionSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.repositories.MotionSensor;
import com.petalone.petalone.infraestructure.repositories.MotionSensorRepository;
import com.petalone.petalone.infraestructure.repositories.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Qualifier("PostgresMotionSensorRepository")
@Repository("motionsensorPersistence")
public class PostgresMotionSensorRepository implements MotionSensorAble {

    @Autowired
    private MotionSensorRepository motionSensorRepository;

    @Override
    public MotionSensorDTO save(MotionSensorDTO motionSensorDTO) {
        return motionSensorRepository.save(new MotionSensor(motionSensorDTO)).toMotionSensorDTO();
    }

    @Override
    public MotionSensorDTO update(MotionSensorDTO motionSensorDTO) throws PetalonException {
        if (motionSensorRepository.existsById(motionSensorDTO.getIdSensor())) {
            try {
                return
                        motionSensorRepository.save(new MotionSensor(motionSensorDTO)).toMotionSensorDTO();

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
        if (motionSensorRepository.existsById(idSensor)) {
            try {
                motionSensorRepository.deleteById(idSensor);
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
    public List<MotionSensorDTO> list() {
        List<MotionSensor> motionSensors=motionSensorRepository.findAll();
        List<MotionSensorDTO> motionSensorDTOS= new ArrayList<>();
        for (MotionSensor motionSensor:motionSensors)
        {
            motionSensorDTOS.add(motionSensor.toMotionSensorDTO());
        }
        return motionSensorDTOS;
    }
}
