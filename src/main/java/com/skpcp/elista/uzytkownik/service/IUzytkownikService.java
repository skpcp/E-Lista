package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */

public interface IUzytkownikService {
    UzytkownikDTO znajdzUzytkownikaPoId(Long aId);
    List<UzytkownikDTO> znajdzWszystkichUzytkownikow();
    List<UzytkownikDTO> znajdzUzytkownikaPoImieniu(String aImie);
    List<UzytkownikDTO> znajdzUzytkownikaPoNazwisku(String aNazwisko);
    List<UzytkownikDTO> znajdzUzytkownikaPoImieniuINazwisku(String aImie,String aNazwisko);
    UzytkownikDTO zapiszUzytkownika(UzytkownikDTO aUzytkownikDTO);
    void usunUzytkownika(Long aId);

}
