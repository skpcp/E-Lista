package com.skpcp.elista.czaspracy.service;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
public interface ICzasPracyService {
    List<CzasPracyDTO> wyswietlCzasyPracyPoUzytkowniku(Long aIdUzytkownika);
    CzasPracyDTO zapiszCzasPracyWedlugPlanu(CzasPracyDTO aCzasPracyDTO);
    CzasPracyDTO zapiszCzasPracy(CzasPracyDTO aCzasPracyDTO);
    void usunCzasPracy(Long aId);
    CzasPracyDTO znajdzCzasPracyPoId(Long aId);
}