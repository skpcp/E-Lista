package com.skpcp.elista.uzytkownik.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.grupa.ob.GrupaOB;
import com.skpcp.elista.uzytkownik.EStan;

import javax.persistence.*;

/**
 * Created by   Tomek on 2016-03-19.
 */
@Entity
@Table (name = "uzytkownicy")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_UZYTKOWNIK_ID")
public class UzytkownikOB extends BaseOB {
    private String imie;
    private String nazwisko;
    @Column(unique = true)
    private String email;
    private String haslo;
    @Column(length = 14)
    private String telefon;
    private EStan aktywnosc;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GURPA_ID", referencedColumnName = "ID")
    private GrupaOB grupa;

    public UzytkownikOB() {

    }

    public UzytkownikOB(String email,String haslo){
        this.email = email;
        this.haslo = haslo;
    }

    public UzytkownikOB(String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;

    }

    public UzytkownikOB(String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc, GrupaOB grupa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
        this.grupa = grupa;
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

    public GrupaOB getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaOB grupa) {
        this.grupa = grupa;
    }
}
