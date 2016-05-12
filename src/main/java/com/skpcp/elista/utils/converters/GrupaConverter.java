package com.skpcp.elista.utils.converters;

import com.skpcp.elista.grupa.dto.*;
import com.skpcp.elista.grupa.ob.GrupaOB;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public class GrupaConverter {

    public static GrupaDTOUzytkownik grupaOBDoGrupaDTOUzytkownik(GrupaOB aGrupaOB){
        if(aGrupaOB == null) return null;
        return new GrupaDTOUzytkownik(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa(),UzytkownikConverter.uzytkownikOBDoUzytkownikaDTOBezHasla(aGrupaOB.getLider()));
    }


    public static GrupaDTOBezLidera grupaOBDoGrupaDTOBezLider(GrupaOB aGrupaOB){
        if(aGrupaOB ==null) return null;
        return new GrupaDTOBezLidera(aGrupaOB.getNazwa());
    }


    public static GrupaDTOBezLiderAleZIdTechDate grupaOBDoGrupaDTOBezLiderAleZIdTechDate(GrupaOB aGrupaOB){
        if(aGrupaOB == null) return null;
        return new GrupaDTOBezLiderAleZIdTechDate(aGrupaOB.getId(),aGrupaOB.getTechDate(),aGrupaOB.getNazwa());
    }
}
