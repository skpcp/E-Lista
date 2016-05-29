package com.skpcp.elista.czaspracy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */

@ApiModel
public class CzasPracyDTOBezUzytkownika extends BaseDTO{
    private String dzien;
    private String rozpoczecie;
    private String zakonczenie;
    private String zakresPracy;

    public CzasPracyDTOBezUzytkownika() {
    }

    public CzasPracyDTOBezUzytkownika(String dzien, String rozpoczecie, String zakonczenie, String zakresPracy) {
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public CzasPracyDTOBezUzytkownika(Long id, Date techDate, String dzien, String rozpoczecie, String zakonczenie, String zakresPracy) {
        super(id, techDate);
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
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
