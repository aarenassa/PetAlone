package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.MotionSensorDTO;
import com.petalone.petalone.domain.PetDTO;
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
public class MotionSensor {

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

    public MotionSensor(MotionSensorDTO motionSensorDTO) {
        BeanUtils.copyProperties(motionSensorDTO, this);
        this.idSensor = java.util.UUID.randomUUID().toString();
    }

    public MotionSensorDTO toMotionSensorDTO()
    {
        MotionSensorDTO motionSensorDTO=new MotionSensorDTO();
        BeanUtils.copyProperties( this,motionSensorDTO);
        return motionSensorDTO;
    }
}
