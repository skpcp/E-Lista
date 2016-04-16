package com.skpcp.elista.czaspracy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class CzasPracyDTO extends BaseDTO{
    private UzytkownikDTO uzytkownik;
    private Date dzien;
    private Date rozpoczecie;
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyDTO() {
    }

    public CzasPracyDTO(Long id, Date techDate, UzytkownikDTO uzytkownik, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        super(id,techDate);
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public UzytkownikDTO getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTO uzytkownik) {
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
