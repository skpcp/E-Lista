package com.skpcp.elista.czaspracy.service;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;

import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
public interface ICzasPracyService {
    List<CzasPracyDTO> wyswietlCzasyPracyPoUzytkowniku(Long aIdUzytkownika);
    CzasPracyDTO zapiszCzasPracyWedlugPlanu(CzasPracyDTO aCzasPracyDTO) throws MyServerException;
    CzasPracyDTO zapiszCzasPracy(CzasPracyDTO aCzasPracyDTO) throws  MyServerException;
    void usunCzasPracy(Long aId);
    CzasPracyDTO znajdzCzasPracyPoId(Long aId) throws MyServerException;
}