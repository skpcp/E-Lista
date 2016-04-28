package com.skpcp.elista.grupa.service;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.dto.GrupaUzytkownikDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;


/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public interface IGrupaService {

    GrupaDTO zapiszGrupe(GrupaDTO aGrupa) throws MyServerException;
    GrupaDTO znajdzGrupePoId(Long aId) throws MyServerException;
    GrupaDTO dodajUzytkownikDoGrupy(GrupaUzytkownikDTO aGrupaDTO) throws MyServerException;
    GrupaDTO znajdzGrupePoNazwie(String aNazwa) throws MyServerException;
    GrupaDTO znajdzGrupePoLiderzeId(Long aIdLidera)throws MyServerException;
    void usunGrupePoId(Long aId);
}
