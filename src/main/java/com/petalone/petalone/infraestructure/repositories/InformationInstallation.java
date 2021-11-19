package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.InformationInstallationDTO;
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
public class InformationInstallation {


    @Id
    @Column(name = "id_installation", nullable = false)
    private String idInstallation;
    @Basic
    @Column(name = "name_ubication", nullable = true)
    private String nameUbication;
    @Basic
    @Column(name = "name_owner", nullable = true)
    private String nameOwner;
    @Basic
    @Column(name = "devices", nullable = true)
    private String devices;
    @Basic
    @Column(name = "date_installation", nullable = true)
    private Date dateInstallation;
    @Basic
    @Column(name = "who_installed", nullable = true)
    private String whoInstalled;

    public InformationInstallation(InformationInstallationDTO informationInstallationDTO) {
        //Copiar las propiedades del DTO
        //Generar el codigo del perro
        BeanUtils.copyProperties(informationInstallationDTO, this);
        //cmo generar un uuid string
        this.idInstallation = java.util.UUID.randomUUID().toString();

    }

    public InformationInstallationDTO toinformationInstallationDTO()
    {
        InformationInstallationDTO informationInstallationDTO=new InformationInstallationDTO();
        BeanUtils.copyProperties( this,informationInstallationDTO);
        return informationInstallationDTO;
    }
}
