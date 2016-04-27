package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@ApiModel
public class GrupaDTO extends BaseDTO {
    String nazwa;
    UzytkownikDTO lider;
    List<UzytkownikDTO> uzytkownicy;

    public GrupaDTO(){
    }

    public GrupaDTO(Long id, Date techDate, String nazwa, UzytkownikDTO lider, List<UzytkownikDTO> uzytkownicy) {
        super(id, techDate);
        this.nazwa = nazwa;
        this.lider = lider;
        this.uzytkownicy = uzytkownicy;
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

    public List<UzytkownikDTO> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<UzytkownikDTO> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }
}
