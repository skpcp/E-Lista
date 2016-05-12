package com.skpcp.elista.utils.converters;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOBezUzytkownika;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOUzytkownik;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;

/**
 * Created by Achilles on 2016-03-22.
 */
public class CzasPracyConverter {
    public static CzasPracyDTOBezUzytkownika czasPracyOBdoCzasPracyDTOBezUzytkownika(CzasPracyOB aCzasPracyOB){
        if(aCzasPracyOB == null) return null;
        return new CzasPracyDTOBezUzytkownika(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),aCzasPracyOB.getDzien(),aCzasPracyOB.getRozpoczecie(),aCzasPracyOB.getZakonczenie(),aCzasPracyOB.getZakresPracy());
    }

    public static CzasPracyDTOUzytkownik czasPracyOBdoCzasuPracyDTOUzytkownik (CzasPracyOB aCzasPracyOB){
        if(aCzasPracyOB == null) return null;
        return new CzasPracyDTOUzytkownik(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aCzasPracyOB.getUzytkownik()),aCzasPracyOB.getDzien(),aCzasPracyOB.getRozpoczecie(),aCzasPracyOB.getZakonczenie(),aCzasPracyOB.getZakresPracy());
    }

}

