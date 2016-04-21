package com.skpcp.elista.utils;

import com.skpcp.elista.czaspracy.dto.CzasPracyDTO;
import com.skpcp.elista.czaspracy.ob.CzasPracyOB;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Achilles on 2016-03-22.
 */
public class CzasPracyConverter {
    public static CzasPracyOB czprDTOdoCzprOB(CzasPracyDTO aCzasPracyDTO) {
        if (aCzasPracyDTO == null)
            return null;
//        Date dzien = aCzasPracyDTO.getDzien();
//        SimpleDateFormat fMojDzien = new SimpleDateFormat("yyyy-MM-dd");
//        SimpleDateFormat fMojCzas = new SimpleDateFormat("hh-MM");
//        String napis = fMojDzien.format(dzien);
//        Date obcietyDzien;
//        try{
//            obcietyDzien = fMojDzien.parse(napis);
//        }catch(ParseException e){
//            return null;
//        }


        return new CzasPracyOB(UzytkownikConverter.uzytDTOdoUzytkOB(aCzasPracyDTO.getUzytkownik()), aCzasPracyDTO.getDzien(), aCzasPracyDTO.getRozpoczecie(),aCzasPracyDTO.getZakonczenie(), aCzasPracyDTO.getZakresPracy());
    }

    public static CzasPracyDTO czprOBdoCzprDTO(CzasPracyOB aCzasPracyOB) {
        if (aCzasPracyOB == null)
            return null;
        return new CzasPracyDTO(aCzasPracyOB.getId(),aCzasPracyOB.getTechDate(),UzytkownikConverter.uzytOBdoUzytkDTO(aCzasPracyOB.getUzytkownik()),aCzasPracyOB.getDzien(), aCzasPracyOB.getRozpoczecie(), aCzasPracyOB.getZakonczenie(), aCzasPracyOB.getZakresPracy());
    }
}

