package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.SoundSensorDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface SoundSensorAble {
    SoundSensorDTO save(SoundSensorDTO soundSensorDTO);
    SoundSensorDTO update(SoundSensorDTO soundSensorDTO) throws PetalonException;
    boolean delete(String idSensor) throws PetalonException;
    List<SoundSensorDTO> list();
}
