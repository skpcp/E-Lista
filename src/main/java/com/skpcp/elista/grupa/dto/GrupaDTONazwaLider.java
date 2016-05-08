package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOBezHasla;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class GrupaDTONazwaLider extends BaseDTO {
    String nazwa;
    UzytkownikDTOBezHasla lider;

    public GrupaDTONazwaLider() {
    }

    public GrupaDTONazwaLider(String nazwa, UzytkownikDTOBezHasla lider) {
        this.nazwa = nazwa;
        this.lider = lider;
    }

    public GrupaDTONazwaLider(Long id, Date techDate, String nazwa, UzytkownikDTOBezHasla lider) {
        super(id, techDate);
        this.nazwa = nazwa;
        this.lider = lider;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public UzytkownikDTOBezHasla getLider() {
        return lider;
    }

    public void setLider(UzytkownikDTOBezHasla lider) {
        this.lider = lider;
    }
}
