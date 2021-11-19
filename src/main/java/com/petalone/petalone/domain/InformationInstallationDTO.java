package com.petalone.petalone.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationInstallationDTO {

    private String idInstallation;
    private String nameUbication;
    private String nameOwner;
    private String devices;
    @NotNull
    private String whoInstalled;
}
