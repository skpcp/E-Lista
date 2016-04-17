package com.skpcp.elista.uzytkownik.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.dziennikplanow.dto.DziennikPlanowDTO;
import com.skpcp.elista.grupy.dto.GrupaDTO;
import com.skpcp.elista.uzytkownik.EStan;
import io.swagger.annotations.ApiModel;

import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by  Tomek on 2016-03-20.
 */
//Walidacja danych w DTO ,
@ApiModel
public class UzytkownikDTO extends BaseDTO implements Serializable{
    private String imie;
    private String nazwisko;
    private String email;
    private String haslo;
    //co do walidacji telefonu długość nie może przekraczać 14 , i muszą być cyframi
    private String telefon;
    private EStan aktywnosc;
    private GrupaDTO grupa;

    public UzytkownikDTO() {
    }



    public UzytkownikDTO(Long id, Date techDate, String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc) {
        super(id, techDate);
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;

    }

    public UzytkownikDTO(String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc, GrupaDTO grupa) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.haslo = haslo;
        this.telefon = telefon;
        this.aktywnosc = aktywnosc;
        this.grupa = grupa;
    }

    public UzytkownikDTO(Long id, Date techDate, String imie, String nazwisko, String email, String haslo, String telefon, EStan aktywnosc, GrupaDTO grupa) {
        super(id, techDate);
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

    public GrupaDTO getGrupa() {
        return grupa;
    }

    public void setGrupa(GrupaDTO grupa) {
        this.grupa = grupa;
    }
}
