package com.skpcp.elista.utils.converters;

import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTO;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOBezUzytkownika;
import com.skpcp.elista.nieobecnosci.dto.NieobecnoscDTOUzytkownik;
import com.skpcp.elista.nieobecnosci.ob.NieobecnoscOB;

import java.text.SimpleDateFormat;

/**
 * Created by Tomek on 2016-03-22.
 */
public class NieobecnoscConverter {
    public static NieobecnoscDTOUzytkownik nieobecnoscOBDoNieobecnoscDTOUzytkownik(NieobecnoscOB aNieobecnoscOB){
        if(aNieobecnoscOB == null) return null;
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        String dzien = dzienPracy.format(aNieobecnoscOB.getData());
        return new NieobecnoscDTOUzytkownik(aNieobecnoscOB.getId(),aNieobecnoscOB.getTechDate(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aNieobecnoscOB.getUzytkownik()),dzien,aNieobecnoscOB.getIloscGodzin(),aNieobecnoscOB.getTyp());
    }

    public static NieobecnoscDTOBezUzytkownika nieobecnoscOBDoNieobecnoscDTOBezUzytkownika(NieobecnoscOB aNieobecnoscOB){
        if(aNieobecnoscOB == null) return null;
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        String dzien = dzienPracy.format(aNieobecnoscOB.getData());
        return new NieobecnoscDTOBezUzytkownika(aNieobecnoscOB.getId(),aNieobecnoscOB.getTechDate(),dzien,aNieobecnoscOB.getIloscGodzin(),aNieobecnoscOB.getTyp());
    }


}
