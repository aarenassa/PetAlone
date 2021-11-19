package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.SoundSensorDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SoundSensor {

    @Id
    @Column(name = "id_sensor", nullable = false)
    private String idSensor;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;
    @Basic
    @Column(name = "messagge", nullable = true)
    private String messagge;
    @Basic
    @Column(name = "num_serial", nullable = true)
    private String numSerial;
    @Basic
    @Column(name = "address_ubication", nullable = true)
    private String addressUbication;
    @Basic
    @Column(name = "located_at", nullable = true)
    private String locatedAt;
    @Basic
    @Column(name = "num_activity", nullable = true)
    private String numActivity;
    @Basic
    @Column(name = "date_activity", nullable = true)
    private Date dateActivity;

    public SoundSensor(SoundSensorDTO soundSensorDTO) {
        //Copiar las propiedades del DTO
        //Generar el codigo del perro
        BeanUtils.copyProperties(soundSensorDTO, this);
        //cmo generar un uuid string
        this.idSensor = java.util.UUID.randomUUID().toString();

    }

    public SoundSensorDTO tosoundSensorDTo()
    {
        SoundSensorDTO soundSensorDTO=new SoundSensorDTO();
        BeanUtils.copyProperties( this,soundSensorDTO);
        return soundSensorDTO;
    }

}
