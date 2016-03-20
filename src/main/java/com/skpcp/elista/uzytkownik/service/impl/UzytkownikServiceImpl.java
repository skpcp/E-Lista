package com.skpcp.elista.uzytkownik.service.impl;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.repository.IUzytkownikRepository;
import com.skpcp.elista.uzytkownik.service.IUzytkownikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */
@Service
@Transactional
public class UzytkownikServiceImpl implements IUzytkownikService {

    @Autowired
    IUzytkownikRepository iUzytkownikRepository;

    @Override
    public UzytkownikDTO znajdzUzytkownikaPoId(Long aId) {
        return null;
    }
}
