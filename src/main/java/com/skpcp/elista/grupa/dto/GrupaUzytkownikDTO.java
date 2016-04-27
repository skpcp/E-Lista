package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
public class GrupaUzytkownikDTO extends BaseDTO {
    String nazwa;
    UzytkownikDTO uzytkownik;

    public GrupaUzytkownikDTO(){}

    public GrupaUzytkownikDTO(Long id, Date techDate, String nazwa, UzytkownikDTO uzytkownik) {
        super(id, techDate);
        this.nazwa = nazwa;
        this.uzytkownik = uzytkownik;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public UzytkownikDTO getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTO uzytkownik) {
        this.uzytkownik = uzytkownik;
    }
}
