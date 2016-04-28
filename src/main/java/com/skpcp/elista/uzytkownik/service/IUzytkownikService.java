package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;
import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */

public interface IUzytkownikService {
    UzytkownikDTO znajdzUzytkownikaPoId(Long aId) throws MyServerException;
    List<UzytkownikDTO> znajdzWszystkichUzytkownikow();
    List<UzytkownikDTO> znajdzUzytkownikowPoImieniu(String aImie);
    List<UzytkownikDTO> znajdzUzytkownikowPoNazwisku(String aNazwisko);
    List<UzytkownikDTO> znajdzUzytkownikowPoImieniuINazwisku(String aImie, String aNazwisko);
    UzytkownikDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO) throws MyServerException;
    void usunUzytkownika(Long aId);
    List<UzytkownikDTO> znajdzUzytkownikowPoAktywnosci(EStan aAktywnosc);
    List<UzytkownikDTO> znajdzUzytkownikowPoNazwieRoli(String aNazwa);

}
