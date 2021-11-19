package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetUbicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PetUbication {

    @Id
    @Column(name = "id_ubication", nullable = false)
    private String idUbication;
    @Basic
    @Column(name = "num_identification", nullable = true)
    private String numIdentification;
    @Basic
    @Column(name = "name_ubication", nullable = true)
    private String nameUbication;
    @Basic
    @Column(name = "address", nullable = true)
    private String address;
    @Basic
    @Column(name = "num_phone", nullable = true)
    private String numPhone;

    public PetUbication(PetUbicationDTO petubcationDTO) {
        //Copiar las propiedades del DTO
        //Generar el codigo del perro
        BeanUtils.copyProperties(petubcationDTO, this);
        //cmo generar un uuid string
        this.idUbication = java.util.UUID.randomUUID().toString();

    }

    public PetUbicationDTO topetUbicationDto()
    {
        PetUbicationDTO petUbicationDTO=new PetUbicationDTO();
        BeanUtils.copyProperties( this,petUbicationDTO);
        return petUbicationDTO;
    }


}
