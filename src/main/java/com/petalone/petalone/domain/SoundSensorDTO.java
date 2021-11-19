package com.petalone.petalone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Size;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SoundSensorDTO {

    private String idSensor;
    @Size(min = 2, max = 20)
    private String name;
    @Size(min = 2, max = 20)
    private String messagge;
    private String numSerial;
    private String addressUbication;
    private String locatedAt;   //Lugar de la casa en donde se instalo


}