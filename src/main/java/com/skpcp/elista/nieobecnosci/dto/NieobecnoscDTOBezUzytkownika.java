package com.skpcp.elista.nieobecnosci.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class NieobecnoscDTOBezUzytkownika extends BaseDTO {
    private Date data;
    private Long ilosc;
    private String typ;

    public NieobecnoscDTOBezUzytkownika() {
    }

    public NieobecnoscDTOBezUzytkownika(Date data, Long ilosc, String typ) {
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public NieobecnoscDTOBezUzytkownika(Long id, Date techDate, Date data, Long ilosc, String typ) {
        super(id, techDate);
        this.data = data;
        this.ilosc = ilosc;
        this.typ = typ;
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
