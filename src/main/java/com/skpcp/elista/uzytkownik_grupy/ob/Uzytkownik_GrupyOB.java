package com.skpcp.elista.uzytkownik_grupy.ob;

import com.skpcp.elista.BaseOB;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by  Tomek on 2016-03-20.
 */
@Entity
@Table(name = "uzytkownik_grupy")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_UZYT_GRUPY_ID")
public class Uzytkownik_GrupyOB extends BaseOB implements Serializable {
    private Long idUzytkownika;
    private Long idGrupy;

    public Uzytkownik_GrupyOB() {
    }

    public Uzytkownik_GrupyOB(Long idUzytkownika, Long idGrupy) {
        this.idUzytkownika = idUzytkownika;
        this.idGrupy = idGrupy;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public Long getIdGrupy() {
        return idGrupy;
    }

    public void setIdGrupy(Long idGrupy) {
        this.idGrupy = idGrupy;
    }
}
