package com.skpcp.elista.nieobecnosci.ob;

import com.skpcp.elista.BaseOB;
import com.skpcp.elista.nieobecnosci.EJednostka;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-19.
 */
@Entity
@Table(name = "nieobecnosci")
@SequenceGenerator(allocationSize = 1, name="SEQ",sequenceName = "GEN_NIEOBECNOSC_ID")
public class NieobecnosciOB extends BaseOB implements Serializable
{
    private Long idUzytkownika;
    private Date data;
    private Long ilosc;
    private EJednostka typ;

    public NieobecnosciOB() {
    }

    public NieobecnosciOB(Long idUzytkownika, Date date, Long ilosc, EJednostka typ) {
        this.idUzytkownika = idUzytkownika;
        this.data = date;
        this.ilosc = ilosc;
        this.typ = typ;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long userID) {
        this.idUzytkownika = userID;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date date) {
        this.data = date;
    }

    public Long getIlosc() {
        return ilosc;
    }

    public void setIlosc(Long ilosc) {
        this.ilosc = ilosc;
    }

    public EJednostka getTyp() {
        return typ;
    }

    public void setTyp(EJednostka typ) {
        this.typ = typ;
    }
}
