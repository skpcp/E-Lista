package com.skpcp.elista.uzytkownik.service;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.List;

/**
 * Created by Tomek on 2016-03-20.
 */

public interface IUzytkownikService {
    UzytkownikDTO znajdzUzytkownikaPoId(Long aId);
    List<UzytkownikDTO> findAllUsers();
    List<UzytkownikDTO> findUsersByName(String aImie);
    List<UzytkownikDTO> findUsersByLastName(String aNazwisko);
    List<UzytkownikDTO> findUsersByNames(String aImie,String aNazwisko);
    UzytkownikDTO saveUser(UzytkownikDTO aUzytkownikDTO);
    void deleteUser(Long aId);

}
