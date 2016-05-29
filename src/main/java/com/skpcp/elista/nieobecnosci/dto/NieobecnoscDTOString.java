package com.skpcp.elista.nieobecnosci.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

@ApiModel
public class NieobecnoscDTOString implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private String data;
    private Long ilosc;
    private String typ;

    public NieobecnoscDTOString() {
    }

    public NieobecnoscDTOString(Long id, Long uzytkownikId, String data, Long ilosc, String typ) {
        this.id = id;
        this.uzytkownikId = uzytkownikId;
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

    public Long getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Long uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
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
