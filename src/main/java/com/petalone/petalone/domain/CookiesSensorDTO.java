package com.petalone.petalone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookiesSensorDTO {

    private String name;
    private String messagge;
    private String numSerial;
    private String addressUbication;
    private String locatedAt;
    private String id;
}

