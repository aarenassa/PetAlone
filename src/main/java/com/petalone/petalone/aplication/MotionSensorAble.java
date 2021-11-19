package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.MotionSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface MotionSensorAble {
    MotionSensorDTO save(MotionSensorDTO motionSensorDTO);
    MotionSensorDTO update(MotionSensorDTO motionSensorDTO) throws PetalonException;
    boolean delete(String idSensor) throws PetalonException;
    List<MotionSensorDTO> list();
}
