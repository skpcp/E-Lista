package com.skpcp.elista.nieobecnosci.service;


import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;



import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-03-22.
 */
public interface INieobecnoscService {
    NieobecnoscDTO znajdzNieobecnoscPoId(Long aID);
    List<NieobecnoscDTO> znajdzWszystkieNieobecnosci();
    List<NieobecnoscDTO> znajdzNieobecnoscPoIdUzytkownika(Long aIdUzytkownika);
    NieobecnoscDTO znajdzNieobecnoscPoDacieIUzytkowniku(Date aData, Long aIdUzytkownika);
    List<NieobecnoscDTO> znajdzNieobecnosciPoTypie(String aTyp);
    List<NieobecnoscDTO> znajdzNieobecnosciPoTypieIUzytkowniku(String aTyp, Long aIdUzytkownika);
    NieobecnoscDTO zapiszNieobecnosc(NieobecnoscDTO aNieobecnosciDTO);
    void usunNieobecnosci(Long aId);
//    NieobecnoscDTO zmienTypNiebecnosciPoId(EJednostka aID);
//    NieobecnoscDTO zmienIloscNieobecnosciPoId(Integer aID);
//    NieobecnoscDTO zmienDateNieobecnosciPoId(Date aID);

}
