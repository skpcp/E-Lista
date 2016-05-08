package com.skpcp.elista.utils.converters;

import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezUzytkownika;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOUzytkownik;
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

    public static NieobecnoscDTOUzytkownik nieobecnoscDTOdoNieobecnoscDTOUzytkownik(NieobecnoscDTO aNieobecnoscDTO){
        if(aNieobecnoscDTO == null) return null;
        return new NieobecnoscDTOUzytkownik(aNieobecnoscDTO.getId(),aNieobecnoscDTO.getTechDate(),UzytkownikConverter.uzytkownikDTOdoUzytkownikDTOBezHasla(aNieobecnoscDTO.getUzytkownik()),aNieobecnoscDTO.getData(),aNieobecnoscDTO.getIlosc(),aNieobecnoscDTO.getTyp());
    }

    public static NieobecnoscDTOBezUzytkownika nieobecnoscDTOdoNieobecnoscDTOBezUzytkownika(NieobecnoscDTO aNieobecnoscDTO){
        if(aNieobecnoscDTO == null) return null;
        return new NieobecnoscDTOBezUzytkownika(aNieobecnoscDTO.getId(),aNieobecnoscDTO.getTechDate(),aNieobecnoscDTO.getData(),aNieobecnoscDTO.getIlosc(),aNieobecnoscDTO.getTyp());
    }
}
