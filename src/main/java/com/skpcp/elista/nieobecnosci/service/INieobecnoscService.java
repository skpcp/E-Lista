package com.skpcp.elista.nieobecnosci.service;


import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezTechDate;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezUzytkownika;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOUzytkownik;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.utils.exceptions.MyServerException;


import java.util.Date;
import java.util.List;

/**
 * Created by IGOR on 2016-03-22.
 */
public interface INieobecnoscService {
    NieobecnoscDTOUzytkownik znajdzNieobecnoscPoId(Long aID) throws MyServerException;
    List<NieobecnoscDTOUzytkownik> znajdzWszystkieNieobecnosci();
    List<NieobecnoscDTOUzytkownik> znajdzNieobecnoscPoIdUzytkownika(Long aIdUzytkownika);
    NieobecnoscDTOBezUzytkownika znajdzNieobecnoscPoDacieIUzytkowniku(Date aData, Long aIdUzytkownika) throws MyServerException;
    List<NieobecnoscDTOUzytkownik> znajdzNieobecnosciPoTypie(String aTyp);
    List<NieobecnoscDTOBezUzytkownika> znajdzNieobecnosciPoTypieIUzytkowniku(String aTyp, Long aIdUzytkownika);
    NieobecnoscDTOUzytkownik zapiszNieobecnosc(NieobecnoscDTOBezTechDate aNieobecnosciDTO) throws MyServerException;
    void usunNieobecnosci(Long aId);
//    NieobecnoscDTO zmienTypNiebecnosciPoId(EJednostka aID);
//    NieobecnoscDTO zmienIloscNieobecnosciPoId(Integer aID);
//    NieobecnoscDTO zmienDateNieobecnosciPoId(Date aID);

}
