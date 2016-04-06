package com.skpcp.elista.utils;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;

/**
 * Created by Achilles on 2016-03-22.
 */
public class CzasPracyConverter {
    public static CzasPracyOB czprDTOdoCzprOB(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null)
            return null;
        return new CzasPracyOB(aCzasPracyDTO.getIdUzytkownika(), aCzasPracyDTO.getDzien(), aCzasPracyDTO.getRozpoczecie(), aCzasPracyDTO.getZakonczenie(), aCzasPracyDTO.getZakresPracy());
    }

    public static CzasPracyDTO czprOBdoCzprDTO(CzasPracyOB aCzasPracyOB) {
        if (aCzasPracyOB == null)
            return null;
        return new CzasPracyDTO(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(), aCzasPracyOB.getIdUzytkownika(), aCzasPracyOB.getDzien(), aCzasPracyOB.getRozpoczecie(), aCzasPracyOB.getZakonczenie(), aCzasPracyOB.getZakresPracy());
    }
}

