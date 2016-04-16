package com.skpcp.elista.uprawnienia.ob;

import com.skpcp.elista.base.ob.BaseOB;

import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Created by Tomasz Komoszeski on 2016-04-16.
 */
@Entity
@Table(name = "uprawnienia")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_UPRAWNIENIE_ID")
public class UprawnienieOB extends BaseOB {
    private String nazwa;

    public UprawnienieOB() {
    }

    public UprawnienieOB(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
