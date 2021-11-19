package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.SoundSensorAble;
import com.petalone.petalone.domain.SoundSensorDTO;
import com.petalone.petalone.exeption.PetalonException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class SoundSensorimpl implements SoundSensorAble {

    @Autowired
    @Qualifier("PostgresSoundSensorRepository")
    private SoundSensorAble soundSensorPersistence;

    @Override
    public SoundSensorDTO save(SoundSensorDTO soundSensorDTO)
    { return soundSensorPersistence.save(soundSensorDTO); }

    @Override
    public SoundSensorDTO update(SoundSensorDTO soundSensorDTO) throws PetalonException{
        return soundSensorPersistence
                .update(soundSensorDTO);
    }

    @Override
    public boolean delete(String idSensor) throws PetalonException
    { return soundSensorPersistence.delete(idSensor);  }

    @Override
    public List<SoundSensorDTO> list() { return soundSensorPersistence.list(); }
}
