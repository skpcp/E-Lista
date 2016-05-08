package com.skpcp.elista.nieobecnosci.dto;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */

@ApiModel
public class NieobecnoscDTOBezTechDate implements Serializable {
    private Long id;
    private UzytkownikDTOEmail uzytkownik;
    private Date data;
    private Long ilosc;
    private String typ;

    public NieobecnoscDTOBezTechDate(){

    }

    public NieobecnoscDTOBezTechDate(Long id, UzytkownikDTOEmail uzytkownik, Date data, Long ilosc, String typ) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UzytkownikDTOEmail getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOEmail uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Long getIlosc() {
        return ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
