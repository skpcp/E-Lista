package com.skpcp.elista.utils;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

/**
 * Created by Tomek on 2016-03-20.
 */
public class UzytkownikConverter {
    public static UzytkownikOB uzytDTOdoUzytkOB(UzytkownikDTO aUzytkownikDTO){
        if(aUzytkownikDTO == null)//zapezpieczenie
            return null;
        return new UzytkownikOB(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc());
    }

    public static UzytkownikDTO uzytOBdoUzytkDTO(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB ==null) return null;
        return new UzytkownikDTO(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getHaslo(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc());
    }
}
