package com.skpcp.elista.utils;

import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.grupy.api.GrupaController;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Tomek on 2016-03-20.
 */
public class UzytkownikConverter {
    public static UzytkownikDTO uzytOBdoUzytkDTO(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB ==null) return null;
        return new UzytkownikDTO(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getHaslo(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc(),GrupaConverter.grupyOBdogrupyDTO(aUzytkownikOB.getGrupa()));
    }

    public static UzytkownikOB uzytDTOdoUzytkOB(UzytkownikDTO aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        UzytkownikOB pUzytkownikOB = new UzytkownikOB(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc(), GrupaConverter.grupyDTOdogrupyOB(aUzytkownikDTO.getGrupa()));
        pUzytkownikOB.setId(aUzytkownikDTO.getId());
        pUzytkownikOB.setTechDate(aUzytkownikDTO.getTechDate());
        return pUzytkownikOB;
    }

    public static List<UzytkownikDTO> listUzytkOBdoUzytkDTO(List<UzytkownikOB> aListaUzytkownikowOB)
    {
        List<UzytkownikDTO> pListaUzytkownikowDTO = new ArrayList<>();
        for(UzytkownikOB uzytkownik : aListaUzytkownikowOB)
        {
            pListaUzytkownikowDTO.add(uzytOBdoUzytkDTO(uzytkownik));
        }
        return pListaUzytkownikowDTO;
    }

    public static List<UzytkownikOB> listUzytkDTOdoUzytkOB(List<UzytkownikDTO> aListaUzytkownikowDTO){
        List<UzytkownikOB> pListaUzytkownikowOB = new ArrayList<>();
        for(UzytkownikDTO uzytkownikDTO : aListaUzytkownikowDTO){
            pListaUzytkownikowOB.add(uzytDTOdoUzytkOB(uzytkownikDTO));
        }
        return pListaUzytkownikowOB;
    }
}
