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

    public UzytkownikOB() {

    }

    public UzytkownikOB(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
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


}
