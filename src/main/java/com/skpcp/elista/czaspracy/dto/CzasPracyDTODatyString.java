package com.skpcp.elista.czaspracy.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

@ApiModel
public class CzasPracyDTODatyString implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private String dzien;
    private String rozpoczecie;
    private String zakonczenie;
    private String zakresPracy;

    public CzasPracyDTODatyString(Long id, Long uzytkownikId, String dzien, String rozpoczecie, String zakonczenie, String zakresPracy) {
        this.id = id;
        this.uzytkownikId = uzytkownikId;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public CzasPracyDTODatyString() {
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
