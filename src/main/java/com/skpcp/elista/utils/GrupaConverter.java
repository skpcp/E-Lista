package com.skpcp.elista.utils;

import com.skpcp.elista.grupa.dto.GrupaDTO;
import com.skpcp.elista.grupa.ob.GrupaOB;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public class GrupaConverter {

   public static GrupaOB grupaDTOdoGrupyOB(GrupaDTO aGrupaDTO){
       return new GrupaOB(aGrupaDTO.getNazwa(),UzytkownikConverter.uzytDTOdoUzytkOB(aGrupaDTO.getLider()),UzytkownikConverter.listUzytkDTOdoUzytkOB(aGrupaDTO.getUzytkownicy()));
   }

    public static GrupaDTO grupaOBdoGrupyDTO(GrupaOB aGrupaOB){
        return new GrupaDTO(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa(),UzytkownikConverter.uzytOBdoUzytkDTO(aGrupaOB.getLider()),UzytkownikConverter.listUzytkOBdoUzytkDTO(aGrupaOB.getUzytkownicy()));
    }
}
