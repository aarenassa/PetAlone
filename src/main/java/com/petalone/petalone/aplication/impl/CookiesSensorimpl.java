package com.petalone.petalone.aplication.impl;

import com.petalone.petalone.aplication.CookiesSensorAble;
import com.petalone.petalone.aplication.PetAble;
import com.petalone.petalone.domain.CookiesSensorDTO;
import com.petalone.petalone.domain.PetDTO;
import com.petalone.petalone.exeption.PetalonException;
import com.petalone.petalone.infraestructure.adapters.PostgresCookiesRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CookiesSensorimpl implements CookiesSensorAble {

    @Autowired
    @Qualifier("PostgresCookiesRepository")
    private CookiesSensorAble cookiesPersistence;

    @Override
    public CookiesSensorDTO save(CookiesSensorDTO cookiesSensorDTO) {
        return cookiesPersistence.save(cookiesSensorDTO);
    }

    @Override
    public CookiesSensorDTO update(CookiesSensorDTO cookiesSensorDTO) throws PetalonException{
        return cookiesPersistence.update(cookiesSensorDTO);
    }

    @Override
    public boolean delete(String id) throws PetalonException {
        return cookiesPersistence.delete(id);
    }

    @Override
    public List<CookiesSensorDTO> list() {
        return cookiesPersistence.list();
    }
}
