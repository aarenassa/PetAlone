package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.MotionSensorAble;
import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.MotionSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MotionSensorimpl implements MotionSensorAble {

    @Autowired
    @Qualifier("PostgresMotionSensorRepository")
    private MotionSensorAble motionSensorPersistence;

    @Override
    public MotionSensorDTO save(MotionSensorDTO motionSensorDTO)
    {
        return motionSensorPersistence.save(motionSensorDTO);
    }

    @Override
    public MotionSensorDTO update(MotionSensorDTO motionSensorDTO) throws PetalonException {
        return motionSensorPersistence.update(motionSensorDTO);
    }

    @Override
    public boolean delete(String idSensor) throws PetalonException {
        return motionSensorPersistence.delete(idSensor);
    }

    @Override
    public List<MotionSensorDTO> list() {
        return motionSensorPersistence.list();
    }
}
