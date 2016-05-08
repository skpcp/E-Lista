package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
public class GrupaDTOLider implements Serializable {
    UzytkownikDTOEmail lider;

    public GrupaDTOLider(){

    }

    public GrupaDTOLider(UzytkownikDTOEmail lider) {
        this.lider = lider;
    }

    public UzytkownikDTOEmail getLider() {
        return lider;
    }

    public void setLider(UzytkownikDTOEmail lider) {
        this.lider = lider;
    }
}
