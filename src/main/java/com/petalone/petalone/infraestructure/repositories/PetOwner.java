package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_owner", schema = "public", catalog = "petalone1")
public class PetOwner {

    @Id
    @Column(name = "num_indentification", nullable = false, length = 5)
    private String numIndentification;
    @Basic
    @Column(name = "id_type", nullable = true, length = 15)
    private String idType;
    @Basic
    @Column(name = "name", nullable = true, length = 20)
    private String name;
    @Basic
    @Column(name = "last_name", nullable = true, length = 20)
    private String lastName;
    @Basic
    @Column(name = "num_phone", nullable = true, length = 15)
    private String numPhone;
    @Basic
    @Column(name = "email", nullable = true, length = 20)
    private String email;
}
