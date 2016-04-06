package com.skpcp.elista.nieobecnosci.service;

import com.skpcp.elista.nieobecnosci.EJednostka;
import com.skpcp.elista.nieobecnosci.dto.NieobecnosciDTO;

import java.util.Date;

/**
 * Created by IGOR on 2016-03-22.
 */
public interface INieobecnosciService {

    NieobecnosciDTO znajdzNieobecnoscPoId(Long aID);
    List<NieobecnosciDTO> znajdzWszystkieNieobecnosci();
    List<NieobecnosciDTO> znajdzNieobecnoscPoIdUzytkownika(Long aID);
    List<NieobecnosciDTO> znajdzNieobecnoscPoDacie(Date aID);
    List<NieobecnosciDTO> znajdzNieobecnoscPoTypie(EJednostka aID);
    NieobecnosciDTO zapiszNieobecnosci(NieobecnosciDTO aNieobecnosci);
    void usunNieobecnosci(Long aID);
    NieobecnosciDTO zmienTypNiebecnosciPoId(EJednostka aID);
    NieobecnosciDTO zmienIloscNieobecnosciPoId(Integer aID);
    NieobecnosciDTO zmienDateNieobecnosciPoId(Date aID);

}
