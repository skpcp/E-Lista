package com.skpcp.elista.nieobecnosci.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class NieobecnoscDTO extends BaseDTO {
    private UzytkownikDTO uzytkownik;
    private Date data;
    private Long ilosc;
    private String typ;

    public NieobecnoscDTO() {
    }

    public NieobecnoscDTO(Long id, Date techDate, UzytkownikDTO uzytkownik, Date data, Long ilosc, String typ) {
        super(id, techDate);
        this.uzytkownik = uzytkownik;
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public UzytkownikDTO getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTO uzytkownik) {
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
