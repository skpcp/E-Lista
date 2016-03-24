package com.skpcp.elista.utils;

import com.skpcp.elista.nieobecnosci.dto.NieobecnosciDTO;
import com.skpcp.elista.nieobecnosci.ob.NieobecnosciOB;

/**
 * Created by Tomek on 2016-03-22.
 */
public class NieobecnosciConverter {

    public static NieobecnosciOB nieoDTOdoNieoOB(NieobecnosciDTO aNieobecnosciDTO){
        if (aNieobecnosciDTO == null)
            return null;
        return new NieobecnosciOB(aNieobecnosciDTO.getIdUzytkownika(),aNieobecnosciDTO.getData(),aNieobecnosciDTO.getIlosc(),aNieobecnosciDTO.getTyp());
    }
    public static NieobecnosciDTO nieoOBdonieoDTO (NieobecnosciOB aNieobecnosciOB){
        if (aNieobecnosciOB == null)
            return null;
        return new NieobecnosciDTO(aNieobecnosciOB.getId(),aNieobecnosciOB.getTechDate(),aNieobecnosciOB.getIdUzytkownika(),aNieobecnosciOB.getData(),aNieobecnosciOB.getIlosc(),aNieobecnosciOB.getTyp());
    }
}
