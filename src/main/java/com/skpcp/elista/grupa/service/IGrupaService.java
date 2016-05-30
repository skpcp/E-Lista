package com.skpcp.elista.grupa.service;

import com.skpcp.elista.grupa.dto.*;
import com.skpcp.elista.utils.exceptions.MyServerException;

import java.util.List;


/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public interface IGrupaService {

    GrupaDTOUzytkownik zapiszGrupe(GrupaDTOBezIdTechDate aGrupa) throws MyServerException;
    GrupaDTOUzytkownik znajdzGrupePoId(Long aId) throws MyServerException;


    GrupaDTOUzytkownik znajdzGrupePoNazwie(String aNazwa) throws MyServerException;
    List<GrupaDTOUzytkownik> znajdzWszystkieGrupy();
    List<GrupaDTOBezLiderAleZIdTechDate> znajdzGrupePoIdLidera(Long aIdLidera)throws MyServerException;
    List<GrupaDTOBezLiderAleZIdTechDate> znajdzGrupePoNazwieLidera(String aEmail) ;
    void usunGrupePoId(Long aId) throws MyServerException;
}
