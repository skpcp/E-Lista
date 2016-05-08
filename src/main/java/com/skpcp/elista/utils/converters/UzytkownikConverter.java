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
    public static UzytkownikDTO uzytOBdoUzytkDTO(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB ==null) return null;
        return new UzytkownikDTO(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getHaslo(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc(), RolaConverter.rolaOBdoRolaDTO(aUzytkownikOB.getRola()),GrupaConverter.grupaOBdoGrupyDTO(aUzytkownikOB.getGrupa()));
    }

    public static UzytkownikOB uzytDTOdoUzytkOB(UzytkownikDTO aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        UzytkownikOB pUzytkownikOB = new UzytkownikOB(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc(), RolaConverter.rolaDTOdoRolaOB(aUzytkownikDTO.getRola()),GrupaConverter.grupaDTOdoGrupyOB(aUzytkownikDTO.getGrupa()));
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

    public static UzytkownikDTOBezHasla uzytkownikOBDoUzytkownikaDTOBezHasla(UzytkownikOB aUzytkownikOB){
        if(aUzytkownikOB == null) return  null;
        return new UzytkownikDTOBezHasla(aUzytkownikOB.getId(),aUzytkownikOB.getTechDate(),aUzytkownikOB.getImie(),aUzytkownikOB.getNazwisko(),aUzytkownikOB.getEmail(),aUzytkownikOB.getTelefon(),aUzytkownikOB.getAktywnosc(),RolaConverter.rolaOBDoRolaDTOBezUprawnien(aUzytkownikOB.getRola()),GrupaConverter.grupaOBDoGrupaDTOBezLider(aUzytkownikOB.getGrupa()));
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

    public static UzytkownikDTO uzytkownikBezIdTechdateDoUzytkownikDTO (UzytkownikDTOBezIdTechDate aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        return new UzytkownikDTO(aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getHaslo(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc(),RolaConverter.rolaDTOBezUprawnienDoRoliDTO(aUzytkownikDTO.getRola()),GrupaConverter.grupaDTOBezLideraDoGrupaDTO(aUzytkownikDTO.getGrupa()));
    }

    public static UzytkownikDTO uzytkownikDTOBezhaslaDoUzytkownikaDTO(UzytkownikDTOBezHasla aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        return new UzytkownikDTO(aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getEmail(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc(),RolaConverter.rolaDTOBezUprawnienDoRoliDTO(aUzytkownikDTO.getRola()),GrupaConverter.grupaDTOBezLideraDoGrupaDTO(aUzytkownikDTO.getGrupa()));
    }

    public static UzytkownikDTO uzytkownikDTOPodDoUzytkownikDTO(UzytkownikDTOEmail aUzytkownikDTO){
        if(aUzytkownikDTO==null) return null;
        return new UzytkownikDTO(null,null,aUzytkownikDTO.getEmail(),null,null,null,null);
    }

    public static UzytkownikDTOBezHasla uzytkownikDTOdoUzytkownikDTOBezHasla(UzytkownikDTO aUzytkownikDTO){
        if(aUzytkownikDTO == null) return null;
        return new UzytkownikDTOBezHasla(aUzytkownikDTO.getId(),aUzytkownikDTO.getTechDate(),aUzytkownikDTO.getImie(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getNazwisko(),aUzytkownikDTO.getTelefon(),aUzytkownikDTO.getAktywnosc(),RolaConverter.rolaDTOdoRolaDTOBezUprawnien(aUzytkownikDTO.getRola()),GrupaConverter.grupaDTOdoGrupaDTOBezLidera(aUzytkownikDTO.getGrupa()));
    }

    public static UzytkownikDTOEmail uzytkownikDTOdoUzytkownikDTOEmial(UzytkownikDTO aUzytkownikDTO){
        return new UzytkownikDTOEmail(aUzytkownikDTO.getEmail());
    }
}
