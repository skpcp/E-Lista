package com.skpcp.elista.utils.converters;

import com.skpcp.elista.uzytkownik.EStan;
import com.skpcp.elista.uzytkownik.dto.*;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tomek on 2016-03-20.
 */
public class UzytkownikConverter {
    public static UzytkownikDTOBezHasla uzytkownikOBDoUzytkownikaDTOBezHasla(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB == null) return  null;
        return new UzytkownikDTOBezHasla(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc(),RolaConverter.rolaOBdoRolaDTO(aUzytkownikOB.getRola()),GrupaConverter.grupaOBDoGrupaDTOUzytkownik(aUzytkownikOB.getGrupa()));
    }


    public static List<UzytkownikDTOBezHasla> listaUzytkowOBDOListaUzytkownikowDTOBezHasla(List<UzytkownikOB> aListaUzytkownikowOB){
        List<UzytkownikDTOBezHasla> pListaUzytkownikowDTO = new ArrayList<>();
        for(UzytkownikOB uzytkownikOB : aListaUzytkownikowOB){
            pListaUzytkownikowDTO.add(uzytkownikOBDoUzytkownikaDTOBezHasla(uzytkownikOB));
        }
        return pListaUzytkownikowDTO;
    }

    public static UzytkownikOB uzytkownikDTOBezRoliGrupyZHaslemDoUzytkownikaOB(UzytkownikDTOBezRoliGrupyZHaslem aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        return new UzytkownikOB(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(), EStan.OCZEKUJACY,null,null);
    }

    public static UzytkownikDTOBezRoliGrupy uzytkownikOBdoUzytkownikDTOBezRoliGrupy(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB == null) return null;
        return new UzytkownikDTOBezRoliGrupy(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc());
    }

    public static UzytkownikDTOLog uzytkownikOBdoUzytkownikDTOLog(UzytkownikOB aUzytkownikOB){
        return aUzytkownikOB == null ? null : new UzytkownikDTOLog(aUzytkownikOB.getId());
    }



}
