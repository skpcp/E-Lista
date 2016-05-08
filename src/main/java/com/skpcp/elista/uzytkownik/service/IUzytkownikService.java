package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.*;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */

public interface IUzytkownikService {
    UzytkownikDTOBezHasla znajdzUzytkownikaPoId(Long aId) throws MyServerException;
    List<UzytkownikDTOBezHasla> znajdzWszystkichUzytkownikow();
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoImieniu(String aImie);
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwisku(String aNazwisko);
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoImieniuINazwisku(String aImie, String aNazwisko);
    UzytkownikDTOBezHasla zapiszUzytkownika(UzytkownikDTOBezIdTechDate aUzytkownikDTO) throws MyServerException ;
    void dezaktywujUzytkownika(Long aId);
    void aktywujUzytkownika(Long aId) throws MyServerException;
    UzytkownikDTOBezHasla zmienAdresEmailUzytkownika(Long aIdUzytkownika, String aEmail) throws MyServerException;
    void zmienHasloUzytkownika(Long aIdUzytkownika,String haslo) throws MyServerException;
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc);
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwieRoli(String aNazwa);
    UzytkownikDTOBezHasla znajdzUzytkownikaPoEmailu(String aEmail) throws  MyServerException;
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoNazwieGrupy(String aNazwaGrupy);
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowPoIdGrupy(Long aIdGrupy);
    UzytkownikDTOBezRoliGrupy rejestracjaUzytkownika(UzytkownikDTOBezRoliGrupyZHaslem aUzytkownikDTO) throws MyServerException;
    List<UzytkownikDTOBezHasla> znajdzUzytkownikowWGrupiePoAktywnosci(String aNazwaGrupy, EStan aktywnosc);
    UzytkownikDTOBezHasla ustawGrupeDlaUzytkownika(Long aIdUzytkownika,String aNazwaGrupy) throws MyServerException;
}
