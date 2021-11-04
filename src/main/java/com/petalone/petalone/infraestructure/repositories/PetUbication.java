package com.petalone.petalone.infraestructure.repositories;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pet_ubication", schema = "public", catalog = "petalone1")
public class PetUbication {

    @Id
    @Column(name = "id_ubication", nullable = false, length = 5)
    private String idUbication;
    @Basic
    @Column(name = "num_identification", nullable = true, length = 5)
    private String numIdentification;
    @Basic
    @Column(name = "name_ubication", nullable = true, length = 20)
    private String nameUbication;
    @Basic
    @Column(name = "address", nullable = true, length = 15)
    private String address;
    @Basic
    @Column(name = "num_phone", nullable = true, length = 15)
    private String numPhone;

}
