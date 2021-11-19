package com.petalone.petalone.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetDTO {

    @NotNull
    @NotEmpty
    @Size(min = 2,max =20)
    private String name;
    private String id_pet;
    @NotNull
    @Positive
    private short age;
    private String petType;




}
