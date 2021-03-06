package com.petalone.petalone.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetUbicationDTO {


    private String idUbication;
    private String numIdentification; //propietario
    private String nameUbication;
    private String address;
    private String numPhone;
}
