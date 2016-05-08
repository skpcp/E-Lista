package com.skpcp.elista.grupa.dto;


import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-07.
 */
@ApiModel
public class GrupaDTOBezIdTechDate implements Serializable {
    String nazwa;
    UzytkownikDTOEmail lider;

    public GrupaDTOBezIdTechDate(){

    }

    public GrupaDTOBezIdTechDate(String nazwa, UzytkownikDTOEmail lider) {
        this.nazwa = nazwa;
        this.lider = lider;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public UzytkownikDTOEmail getLider() {
        return lider;
    }

    public void setLider(UzytkownikDTOEmail lider) {
        this.lider = lider;
    }
}
