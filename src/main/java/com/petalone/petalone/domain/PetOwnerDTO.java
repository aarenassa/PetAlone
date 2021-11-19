package com.petalone.petalone.domain;


import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PetOwnerDTO {

    @NotNull
    @NotEmpty
    @Size(min = 2,max =30)
    private String numIndentification;
    private String idType;
    @Size(min = 2,max =30)
    private String name;
    private String lastName;
    private String numPhone;
    private String email;
}
