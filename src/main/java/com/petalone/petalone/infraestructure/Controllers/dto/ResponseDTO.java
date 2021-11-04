package com.petalone.petalone.infraestructure.Controllers.dto;

import com.petalone.petalone.domain.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseDTO {

    private String message;
    private Object data;
    private List<ErrorDTO> errors;
}
