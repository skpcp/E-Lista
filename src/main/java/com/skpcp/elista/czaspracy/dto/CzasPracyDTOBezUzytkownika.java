package com.skpcp.elista.czaspracy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */

@ApiModel
public class CzasPracyDTOBezUzytkownika extends BaseDTO{
    private Date dzien;
    private Date rozpoczecie;
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyDTOBezUzytkownika(Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public Date getDzien() {
        return dzien;
    }

    public void setDzien(Date dzien) {
        this.dzien = dzien;
    }

    public Date getRozpoczecie() {
        return rozpoczecie;
    }

    public void setRozpoczecie(Date rozpoczecie) {
        this.rozpoczecie = rozpoczecie;
    }

    public Date getZakonczenie() {
        return zakonczenie;
    }

    public void setZakonczenie(Date zakonczenie) {
        this.zakonczenie = zakonczenie;
    }

    public String getZakresPracy() {
        return zakresPracy;
    }

    public void setZakresPracy(String zakresPracy) {
        this.zakresPracy = zakresPracy;
    }

    public CzasPracyDTOBezUzytkownika(Long id, Date techDate, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        super(id, techDate);
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }
}
