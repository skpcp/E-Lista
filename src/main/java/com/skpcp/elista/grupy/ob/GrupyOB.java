package com.skpcp.elista.grupy.ob;

import com.skpcp.elista.base.ob.BaseOB;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  Tomek on 2016-03-19.
 */
@Entity
@Table(name = "grupy")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_GRUPY_ID")
public class GrupyOB extends BaseOB implements Serializable {
    private Long idUzytkownika;
    private String nazwaGrupy;

    public GrupyOB() {
    }

    public GrupyOB(String idUzytkownika, Long nazwaGrupy) {
        this.idUzytkownika = idUzytkownika;
        this.nazwaGrupy = nazwaGrupy;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public String getNazwaGrupy() {
        return nazwaGrupy;
    }

    public void setNazwaGrupy(String nazwaGrupy) {
        this.nazwaGrupy = nazwaGrupy;
    }
}
