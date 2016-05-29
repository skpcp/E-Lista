package com.skpcp.elista.czaspracy.dto;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

@ApiModel
public class CzasPracyDTOPlanString implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private String dzien;
    private String zakresPracy;
    private String dzienTygodnia;

    public CzasPracyDTOPlanString(Long id, Long uzytkownikId, String dzien, String zakresPracy, String dzienTygodnia) {
        this.id = id;
        this.uzytkownikId = uzytkownikId;
        this.dzien = dzien;
        this.zakresPracy = zakresPracy;
        this.dzienTygodnia = dzienTygodnia;
    }

    public CzasPracyDTOPlanString() {
    }

    public CzasPracyDTOPlanString(Long id, Long uzytkownikId, String dzien, String zakresPracy) {
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

    public String getDzien() {
        return dzien;
    }

    public void setDzien(String dzien) {
        this.dzien = dzien;
    }

    public String getZakresPracy() {
        return zakresPracy;
    }

    public void setZakresPracy(String zakresPracy) {
        this.zakresPracy = zakresPracy;
    }


}
