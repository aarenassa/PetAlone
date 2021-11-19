package com.petalone.petalone.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotionSensorDTO {

    private String idSensor;
    private String name;
    private String messagge;
    private String numSerial;
    private String addressUbication;
    private String locatedAt;
    private String numActivity;
}
