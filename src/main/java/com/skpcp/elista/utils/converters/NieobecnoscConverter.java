package com.skpcp.elista.utils.converters;

import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;

/**
 * Created by Tomek on 2016-03-22.
 */
public class NieobecnoscConverter {

    public static NieobecnoscOB nieoDTOdoNieoOB(NieobecnoscDTO aNieobecnoscDTO){

        return new NieobecnoscOB(UzytkownikConverter.uzytDTOdoUzytkOB(aNieobecnoscDTO.getUzytkownik()), aNieobecnoscDTO.getData(), aNieobecnoscDTO.getIlosc(), aNieobecnoscDTO.getTyp());
    }
    public static NieobecnoscDTO nieoOBdonieoDTO (NieobecnoscOB aNieobecnoscOB){
        if (aNieobecnoscOB == null)
            return null;
        return new NieobecnoscDTO(aNieobecnoscOB.getId(), aNieobecnoscOB.getTechDate(),UzytkownikConverter.uzytOBdoUzytkDTO(aNieobecnoscOB.getUzytkownik()), aNieobecnoscOB.getData(), aNieobecnoscOB.getIloscGodzin(), aNieobecnoscOB.getTyp());
    }
}
