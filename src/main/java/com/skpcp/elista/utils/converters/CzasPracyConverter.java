package com.skpcp.elista.utils.converters;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOBezUzytkownika;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOUzytkownik;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;

import java.text.SimpleDateFormat;

/**
 * Created by Achilles on 2016-03-22.
 */
public class CzasPracyConverter {
    public static CzasPracyDTOBezUzytkownika czasPracyOBdoCzasPracyDTOBezUzytkownika(CzasPracyOB aCzasPracyOB){
        if(aCzasPracyOB == null) return null;
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat czas = new SimpleDateFormat("HH:mm");
        String dzien = dzienPracy.format(aCzasPracyOB.getDzien());
        String rozpoczecie = czas.format(aCzasPracyOB.getRozpoczecie());
        String zakonczenie = czas.format(aCzasPracyOB.getZakonczenie());
        return new CzasPracyDTOBezUzytkownika(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),dzien,rozpoczecie,zakonczenie,aCzasPracyOB.getZakresPracy());
    }

    public static CzasPracyDTOUzytkownik czasPracyOBdoCzasuPracyDTOUzytkownik (CzasPracyOB aCzasPracyOB){
        if(aCzasPracyOB == null) return null;
        SimpleDateFormat dzienPracy = new SimpleDateFormat("YYYY-MM-dd");
        SimpleDateFormat czas = new SimpleDateFormat("HH:mm");
        String dzien = dzienPracy.format(aCzasPracyOB.getDzien());
        String rozpoczecie = czas.format(aCzasPracyOB.getRozpoczecie());
        String zakonczenie = czas.format(aCzasPracyOB.getZakonczenie());
        return new CzasPracyDTOUzytkownik(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aCzasPracyOB.getUzytkownik()),dzien,rozpoczecie,zakonczenie,aCzasPracyOB.getZakresPracy());
    }

}

