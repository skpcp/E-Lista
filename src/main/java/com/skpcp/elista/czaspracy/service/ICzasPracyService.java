package com.skpcp.elista.czaspracy.service;

import com.skpcp.elista.czaspracy.dto.*;
import com.skpcp.elista.utils.exceptions.MyServerException;

import java.util.Date;
import java.util.List;

/**
 * Created by Achilles on 2016-03-22.
 */
public interface ICzasPracyService {
    List<CzasPracyDTOBezUzytkownika> wyswietlCzasyPracyPoUzytkowniku(Long aIdUzytkownika);
    CzasPracyDTOBezUzytkownika wyswietlCzasPracyUzytkownikaPoDacieIPoUzytkowniku(Date aDate, Long aId) throws MyServerException;
    CzasPracyDTOUzytkownik zapiszCzasPracyWedlugPlanu(CzasPracyDTOWedlugPlanu aCzasPracyDTO) throws MyServerException;
    CzasPracyDTOUzytkownik zapiszCzasPracy(CzasPracyDTOBezIdTechDate aCzasPracyDTO) throws  MyServerException;
    void usunCzasPracy(Long aId) throws MyServerException;
    CzasPracyDTOUzytkownik znajdzCzasPracyPoId(Long aId) throws MyServerException;
}