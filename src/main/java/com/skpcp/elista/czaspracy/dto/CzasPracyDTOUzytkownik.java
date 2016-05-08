package com.skpcp.elista.czaspracy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOBezHasla;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class CzasPracyDTOUzytkownik extends BaseDTO {
    UzytkownikDTOBezHasla uzytkownik;
    private Date dzien;
    private Date rozpoczecie;
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyDTOUzytkownik(UzytkownikDTOBezHasla uzytkownik, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public CzasPracyDTOUzytkownik(Long id, Date techDate, UzytkownikDTOBezHasla uzytkownik, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        super(id, techDate);
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public UzytkownikDTOBezHasla getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOBezHasla uzytkownik) {
        this.uzytkownik = uzytkownik;
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
}
