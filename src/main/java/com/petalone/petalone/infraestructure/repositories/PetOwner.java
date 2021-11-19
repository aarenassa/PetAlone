package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.domain.PetOwnerDTO;
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
public class PetOwner {

    @Id
    @Column(name = "num_indentification", nullable = false)
    private String numIndentification;
    @Basic
    @Column(name = "id_type", nullable = true)
    private String idType;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;
    @Basic
    @Column(name = "last_name", nullable = true)
    private String lastName;
    @Basic
    @Column(name = "num_phone", nullable = true)
    private String numPhone;
    @Basic
    @Column(name = "email", nullable = true)
    private String email;

    public PetOwner(PetOwnerDTO petownerDTO) {
        BeanUtils.copyProperties(petownerDTO, this);
        //cmo generar un uuid string
        this.numIndentification = java.util.UUID.randomUUID().toString();

    }

    public PetOwnerDTO toPetOwnerDto()
    {
        PetOwnerDTO petownerDTO = new PetOwnerDTO();
        BeanUtils.copyProperties( this,petownerDTO);
        return petownerDTO;
    }

}
