package com.skpcp.elista.grupa.ob;


import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-04-27.
 */
@Entity
@Table(name = "grupy")
@SequenceGenerator(allocationSize = 1, name = "SEQ", sequenceName = "GEN_GRUPA_ID")
public class GrupaOB extends BaseOB {
    @Column(unique = true)
    String nazwa;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LIDER_ID", referencedColumnName = "ID")
    UzytkownikOB lider;

    public GrupaOB() {
    }

    public GrupaOB(String nazwa, UzytkownikOB lider) {
        this.nazwa = nazwa;
        this.lider = lider;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public UzytkownikOB getLider() {
        return lider;
    }

    public void setLider(UzytkownikOB lider) {
        this.lider = lider;
    }

}
