package com.skpcp.elista.nieobecnosci.ob;

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
@Table(name = "nieobecnosci")
@SequenceGenerator(allocationSize = 1, name="SEQ",sequenceName = "GEN_NIEOBECNOSC_ID")
public class NieobecnoscOB extends BaseOB
{
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UZYTKOWNIK_ID",referencedColumnName = "ID")
    @NotNull
    private UzytkownikOB uzytkownik;
    @Column(columnDefinition = "DATE")
    private Date data;
    private Long iloscGodzin;
    private String typ;

    public NieobecnoscOB() {
    }

    public NieobecnoscOB(UzytkownikOB uzytkownik, Date date, Long iloscGodzin, String typ) {
        this.uzytkownik = uzytkownik;
        this.data = date;
        this.iloscGodzin = iloscGodzin;
        this.typ = typ;
    }

    public UzytkownikOB getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikOB uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date date) {
        this.data = date;
    }

    public Long getIloscGodzin() {
        return iloscGodzin;
    }

    public void setIloscGodzin(Long ilosc) {
        this.iloscGodzin = ilosc;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }
}
