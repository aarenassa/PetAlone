package com.petalone.petalone.infraestructure.repositories;

import com.petalone.petalone.domain.CookiesSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CookiesSensor {

    @Id
    @Column(name = "id", nullable = false)
    private String id;
    @Basic
    @Column(name = "name", nullable = true)
    private String name;
    @Basic
    @Column(name = "messagge", nullable = true)
    private String messagge;
    @Basic
    @Column(name = "num_serial", nullable = true)
    private String numSerial;
    @Basic
    @Column(name = "address_ubication", nullable = true)
    private String addressUbication;
    @Basic
    @Column(name = "located_at", nullable = true)
    private String locatedAt;
    @Basic
    @Column(name = "num_activity", nullable = true)
    private String numActivity;
    @Basic
    @Column(name = "date_activity", nullable = true)
    private Date dateActivity;

    public CookiesSensor(CookiesSensorDTO cookiesSensorDTO) {
        BeanUtils.copyProperties(cookiesSensorDTO, this);
        this.id = java.util.UUID.randomUUID().toString();

    }

    public CookiesSensorDTO toCookiesSensorDTO()
    {
        CookiesSensorDTO cookiesSensorDTO=new CookiesSensorDTO();
        BeanUtils.copyProperties( this,cookiesSensorDTO);
        return cookiesSensorDTO;
    }

}
