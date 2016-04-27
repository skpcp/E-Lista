package com.skpcp.elista.grupa.service.impl;

import com.skpcp.elista.grupa.dto.GrupaBezUDTO;
import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.service.IGrupaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@Service
@Transactional
public class GrupaServiceImpl implements IGrupaService {

    @Override
    public GrupaDTO dodajUzytkownikDoGrupy(Long aIdGrupy, Long aIdUzytkownika) {

        return null;
    }

    @Override
    public GrupaDTO zapiszGrupe(GrupaBezUDTO aGrupa) {

        return null;
    }

    @Override
    public GrupaDTO znajdzGrupePoId(Long aId) {
        return null;
    }

    @Override
    public GrupaDTO znajdzGrupePoNazwie(String aNazwa) {

        return null;
    }

    @Override
    public GrupaDTO znajdzGrupePoLiderzeId(Long aIdLidera) {

        return null;
    }

    @Override
    public void usunGrupePoId(Long aId) {

    }
}
