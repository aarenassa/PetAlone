package com.petalone.petalone.infraestructure.Controllers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorDTO {

    private int num;
    private String message;
}
