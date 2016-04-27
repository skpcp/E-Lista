package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@ApiModel
public class GrupaBezUDTO extends BaseDTO {
    String nazwa;
    UzytkownikDTO lider;

    public GrupaBezUDTO(String nazwa, UzytkownikDTO lider) {
        this.nazwa = nazwa;
        this.lider = lider;
    }

    public GrupaBezUDTO(Long id, Date techDate, String nazwa, UzytkownikDTO lider) {
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

    public UzytkownikDTO getLider() {
        return lider;
    }

    public void setLider(UzytkownikDTO lider) {
        this.lider = lider;
    }
}
