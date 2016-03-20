package com.skpcp.elista.grupy.ob;

import com.skpcp.elista.BaseOB;

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

    public GrupyOB(Long idUzytkownika, String nazwaGrupy) {
        this.idUzytkownika = idUzytkownika;
        this.nazwaGrupy = nazwaGrupy;
    }


}
