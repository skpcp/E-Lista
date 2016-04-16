package com.skpcp.elista.czaspracy.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-19.
 */
@Entity
@Table(name = "czasypracy")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_CZAS_PRACY_ID")
public class CzasPracyOB extends BaseOB{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UZYTKOWNIK_ID",referencedColumnName = "ID")
    @NotNull
    private UzytkownikOB uzytkownik;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dzien;
    @DateTimeFormat(pattern = "HH:mm")
    private Date rozpoczecie;
    @DateTimeFormat(pattern = "HH:mm")
    private Date zakonczenie;
    private String zakresPracy;

    public CzasPracyOB() {
    }

    public CzasPracyOB(UzytkownikOB uzytkownik, Date dzien, Date rozpoczecie, Date zakonczenie, String zakresPracy) {
        this.uzytkownik = uzytkownik;
        this.dzien = dzien;
        this.rozpoczecie = rozpoczecie;
        this.zakonczenie = zakonczenie;
        this.zakresPracy = zakresPracy;
    }


    public UzytkownikOB getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikOB uzytkownik) {
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