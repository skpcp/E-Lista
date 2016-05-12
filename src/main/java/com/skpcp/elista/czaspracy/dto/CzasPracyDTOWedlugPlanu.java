package com.skpcp.elista.czaspracy.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class CzasPracyDTOWedlugPlanu implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private Date dzien;
    private String zakresPracy;

    public CzasPracyDTOWedlugPlanu() {
    }

    public CzasPracyDTOWedlugPlanu(Long id, Long uzytkownikId, Date dzien, String zakresPracy) {
        this.id = id;
        this.uzytkownikId = uzytkownikId;
        this.dzien = dzien;
        this.zakresPracy = zakresPracy;
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

    public Date getDzien() {
        return dzien;
    }

    public void setDzien(Date dzien) {
        this.dzien = dzien;
    }

    public String getZakresPracy() {
        return zakresPracy;
    }

    public void setZakresPracy(String zakresPracy) {
        this.zakresPracy = zakresPracy;
    }
}
