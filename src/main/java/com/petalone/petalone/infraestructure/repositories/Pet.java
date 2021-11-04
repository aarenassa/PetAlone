package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Pet {

    @Id
    @Column(name = "id_pet", nullable = false)
    private String idPet;
    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "age", nullable = true)
    private Short age;
    @Basic
    @Column(name = "pet_type", nullable = true, length = 20)
    private String petType;

    public Pet(PetDTO petDTO) {
        //Copiar las propiedades del DTO
        //Generar el codigo del perro
        BeanUtils.copyProperties(petDTO, this);
        //cmo generar un uuid string
        this.idPet = java.util.UUID.randomUUID().toString();

    }

    public PetDTO toPetDto()
    {
        PetDTO petDTO=new PetDTO();
        BeanUtils.copyProperties( this,petDTO);
        return petDTO;
    }

}
