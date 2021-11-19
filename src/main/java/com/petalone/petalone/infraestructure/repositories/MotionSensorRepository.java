package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.aplication.impl.MotionSensorimpl;
import com.petalone.petalone.aplication.impl.Petimpl;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.Controllers.dto.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


public interface MotionSensorRepository extends JpaRepository<MotionSensor, String> {

}
