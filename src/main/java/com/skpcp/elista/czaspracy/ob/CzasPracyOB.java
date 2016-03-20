package com.skpcp.elista.czaspracy.ob;

import com.skpcp.elista.BaseOB;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-19.
 */
@Entity
@Table(name = "czas_pracy")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_CZAS_PRACY_ID")
public class CzasPracyOB extends BaseOB implements Serializable{
    private Long idUzytkownika;
    private Date dzien;
    private Date rozpoczecie;
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyOB() {
    }

    public CzasPracyOB(Long idUzytkownika, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        this.idUzytkownika = idUzytkownika;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
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