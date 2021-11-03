package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Pet {
    private String idPet;
    private String name;
    private Short age;
    private String petType;

    @Id
    @Column(name = "id_pet", nullable = false, length = 50)
    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    @Basic
    @Column(name = "pet_type", nullable = true, length = 20)
    public String getPetType() {
        return petType;
    }

    public void setPetType(String petType) {
        this.petType = petType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(idPet, pet.idPet) && Objects.equals(name, pet.name) && Objects.equals(age, pet.age) && Objects.equals(petType, pet.petType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPet, name, age, petType);
    }
}
