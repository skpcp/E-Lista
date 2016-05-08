package com.skpcp.elista.uzytkownik.dto;


import com.skpcp.elista.grupa.dto.GrupaDTOBezIdTechDate;
import com.skpcp.elista.grupa.dto.GrupaDTOBezLidera;
import com.skpcp.elista.rola.dto.RolaDTOBezUprawnien;
import com.skpcp.elista.uzytkownik.EStan;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-07.
 */

@ApiModel
public class UzytkownikDTOBezIdTechDate implements Serializable {
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    private String telefon;
    private EStan aktywnosc;
    private RolaDTOBezUprawnien rola;
    private GrupaDTOBezLidera grupa;

    public UzytkownikDTOBezIdTechDate(){

    }

    public UzytkownikDTOBezIdTechDate(String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc, RolaDTOBezUprawnien rola, GrupaDTOBezLidera grupa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
        this.rola = rola;
        this.grupa = grupa;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
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

    public RolaDTOBezUprawnien getRola() {
        return rola;
    }

    public void setRola(RolaDTOBezUprawnien rola) {
        this.rola = rola;
    }

    public GrupaDTOBezLidera getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaDTOBezLidera grupa) {
        this.grupa = grupa;
    }
}
