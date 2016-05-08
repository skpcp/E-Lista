package com.skpcp.elista.utils.converters;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOBezUzytkownika;
import com.skpcp.elista.czaspracy.dto.CzasPracyDTOUzytkownik;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;

/**
 * Created by Achilles on 2016-03-22.
 */
public class CzasPracyConverter {
    public static CzasPracyOB czprDTOdoCzprOB(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null)
            return null;
        return new CzasPracyOB(UzytkownikConverter.uzytDTOdoUzytkOB(aCzasPracyDTO.getUzytkownik()), aCzasPracyDTO.getDzien(), aCzasPracyDTO.getRozpoczecie(),aCzasPracyDTO.getZakonczenie(), aCzasPracyDTO.getZakresPracy());
    }

    public static CzasPracyDTO czprOBdoCzprDTO(CzasPracyOB aCzasPracyOB) {
        if (aCzasPracyOB == null)
            return null;
        return new CzasPracyDTO(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),UzytkownikConverter.uzytOBdoUzytkDTO(aCzasPracyOB.getUzytkownik()),aCzasPracyOB.getDzien(), aCzasPracyOB.getRozpoczecie(), aCzasPracyOB.getZakonczenie(), aCzasPracyOB.getZakresPracy());
    }

    public static CzasPracyDTOUzytkownik czasPracyDTOdoCzasPracyDTOUzytkownik(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null) return null;
        return new CzasPracyDTOUzytkownik(aCzasPracyDTO.getId(), aCzasPracyDTO.getTechDate(), UzytkownikConverter.uzytkownikDTOdoUzytkownikDTOBezHasla(aCzasPracyDTO.getUzytkownik()), aCzasPracyDTO.getDzien(), aCzasPracyDTO.getRozpoczecie(), aCzasPracyDTO.getZakonczenie(), aCzasPracyDTO.getZakresPracy());
    }

    public static CzasPracyDTOBezUzytkownika czasPracyDTOdoCzasPracyDTOBezUzytkownika(CzasPracyDTO aCzasPracyDTO){
        if(aCzasPracyDTO ==null) return null;
        return new CzasPracyDTOBezUzytkownika(aCzasPracyDTO.getId(),aCzasPracyDTO.getTechDate(),aCzasPracyDTO.getDzien(),aCzasPracyDTO.getRozpoczecie(),aCzasPracyDTO.getZakonczenie(),aCzasPracyDTO.getZakresPracy());
    }
}

