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
    private UzytkownikDTOBezHasla uzytkownik;
    private String dzien;
    private String rozpoczecie;
    private String zakonczenie;
    private String zakresPracy;

    public CzasPracyDTOUzytkownik() {
    }

    public CzasPracyDTOUzytkownik(UzytkownikDTOBezHasla uzytkownik, String dzien, String rozpoczecie, String zakonczenie, String zakresPracy) {
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public CzasPracyDTOUzytkownik(Long id, Date techDate, UzytkownikDTOBezHasla uzytkownik, String dzien, String rozpoczecie, String zakonczenie, String zakresPracy) {
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

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public String getRozpoczecie() {
        return rozpoczecie;
    }

    public void setRozpoczecie(String rozpoczecie) {
        this.rozpoczecie = rozpoczecie;
    }

    public String getZakonczenie() {
        return zakonczenie;
    }

    public void setZakonczenie(String zakonczenie) {
        this.zakonczenie = zakonczenie;
    }

    public String getZakresPracy() {
        return zakresPracy;
    }

    public void setZakresPracy(String zakresPracy) {
        this.zakresPracy = zakresPracy;
    }
}
