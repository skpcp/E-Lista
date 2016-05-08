package com.skpcp.elista.nieobecnosci.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOBezHasla;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */

@ApiModel
public class NieobecnoscDTOUzytkownik extends BaseDTO {
    private UzytkownikDTOBezHasla uzytkownik;
    private Date data;
    private Long ilosc;
    private String typ;

    public NieobecnoscDTOUzytkownik(UzytkownikDTOBezHasla uzytkownik, Date data, Long ilosc, String typ) {
        this.uzytkownik = uzytkownik;
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public NieobecnoscDTOUzytkownik(Long id, Date techDate, UzytkownikDTOBezHasla uzytkownik, Date data, Long ilosc, String typ) {
        super(id, techDate);
        this.uzytkownik = uzytkownik;
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public UzytkownikDTOBezHasla getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOBezHasla uzytkownik) {
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
