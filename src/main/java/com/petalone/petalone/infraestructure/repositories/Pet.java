package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pet {

    @Id
    @Column(name = "id_pet", nullable = false, length = 50)
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


}
