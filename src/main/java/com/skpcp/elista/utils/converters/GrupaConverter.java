package com.skpcp.elista.utils.converters;

import com.skpcp.elista.grupa.dto.*;
import com.skpcp.elista.grupa.ob.GrupaOB;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public class GrupaConverter {

   public static GrupaOB grupaDTOdoGrupyOB(GrupaDTO aGrupaDTO){
       if(aGrupaDTO == null) return null;
       GrupaOB pGrupaOB = new GrupaOB(aGrupaDTO.getNazwa(),UzytkownikConverter.uzytDTOdoUzytkOB(aGrupaDTO.getLider()));
       pGrupaOB.setId(aGrupaDTO.getId());
       pGrupaOB.setTechDate(aGrupaDTO.getTechDate());
       return pGrupaOB;
   }

    public static GrupaDTO grupaOBdoGrupyDTO(GrupaOB aGrupaOB){
        if(aGrupaOB == null) return  null;
        return new GrupaDTO(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa(),UzytkownikConverter.uzytOBdoUzytkDTO(aGrupaOB.getLider()));
    }

    public static GrupaDTOUzytkownik grupaOBDoGrupaDTOUzytkownik(GrupaOB aGrupaOB){
        if(aGrupaOB == null) return null;
        return new GrupaDTOUzytkownik(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aGrupaOB.getLider()));
    }

    public static GrupaDTO grupaDTOBezLideraDoGrupaDTO(GrupaDTOBezLidera aGrupaDTO){
        if(aGrupaDTO == null) return null;
        return new GrupaDTO(aGrupaDTO.getNazwa(),null);
    }

    public static GrupaDTOBezLidera grupaOBDoGrupaDTOBezLider(GrupaOB aGrupaOB){
        if(aGrupaOB ==null) return null;
        return new GrupaDTOBezLidera(aGrupaOB.getNazwa());
    }

    public static GrupaDTOBezLidera grupaDTOdoGrupaDTOBezLidera(GrupaDTO aGrupaDTO){
        if(aGrupaDTO == null) return null;
        return new GrupaDTOBezLidera(aGrupaDTO.getNazwa());
    }

    public static GrupaDTOBezLiderAleZIdTechDate grupaOBDoGrupaDTOBezLiderAleZIdTechDate(GrupaOB aGrupaOB){
        if(aGrupaOB == null) return null;
        return new GrupaDTOBezLiderAleZIdTechDate(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa());
    }
}
