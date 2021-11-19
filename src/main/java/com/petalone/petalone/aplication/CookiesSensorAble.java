package com.petalone.petalone.aplication;

import com.petalone.petalone.domain.CookiesSensorDTO;
import com.petalone.petalone.exeption.PetalonException;

import java.util.List;

public interface CookiesSensorAble {
    CookiesSensorDTO save(CookiesSensorDTO cookiesSensorDTO);
    CookiesSensorDTO update(CookiesSensorDTO cookiesSensorDTO) throws PetalonException;
    boolean delete(String id) throws PetalonException;
    List<CookiesSensorDTO> list();
}
