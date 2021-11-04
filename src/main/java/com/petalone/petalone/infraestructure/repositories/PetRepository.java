package com.petalone.petalone.infraestructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, String> {

}
