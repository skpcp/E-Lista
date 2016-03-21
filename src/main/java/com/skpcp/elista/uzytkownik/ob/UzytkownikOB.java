package com.skpcp.elista.uzytkownik.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.uzytkownik.EStan;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by   Tomek on 2016-03-19.
 */
@Entity
@Table (name = "uzytkownicy")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_UZYTKOWNIK_ID")
public class UzytkownikOB extends BaseOB implements Serializable {
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    @Column(length = 14)
    private String telefon;
    private EStan aktywnosc;

    public UzytkownikOB() {

    }


    public UzytkownikOB(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }

    public UzytkownikOB(String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String aImie) {
        this.imie = aImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String aNazwisko) {
        this.nazwisko = aNazwisko;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public EStan getAktywnosc() {
        return aktywnosc;
    }

    public void setAktywnosc(EStan aktywnosc) {
        this.aktywnosc = aktywnosc;
    }
}
