package com.skpcp.elista.nieobecnosci.service;


import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;


import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-03-22.
 */
public interface INieobecnoscService {
    NieobecnoscDTO znajdzNieobecnoscPoId(Long aID) throws MyServerException;
    List<NieobecnoscDTO> znajdzWszystkieNieobecnosci();
    List<NieobecnoscDTO> znajdzNieobecnoscPoIdUzytkownika(Long aIdUzytkownika);
    NieobecnoscDTO znajdzNieobecnoscPoDacieIUzytkowniku(Date aData, Long aIdUzytkownika) throws MyServerException;
    List<NieobecnoscDTO> znajdzNieobecnosciPoTypie(String aTyp);
    List<NieobecnoscDTO> znajdzNieobecnosciPoTypieIUzytkowniku(String aTyp, Long aIdUzytkownika);
    NieobecnoscDTO zapiszNieobecnosc(NieobecnoscDTO aNieobecnosciDTO) throws MyServerException;
    void usunNieobecnosci(Long aId);
//    NieobecnoscDTO zmienTypNiebecnosciPoId(EJednostka aID);
//    NieobecnoscDTO zmienIloscNieobecnosciPoId(Integer aID);
//    NieobecnoscDTO zmienDateNieobecnosciPoId(Date aID);

}
