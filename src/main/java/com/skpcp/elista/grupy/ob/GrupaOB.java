package com.skpcp.elista.grupy.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.uprawnienia.ob.UprawnienieOB;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;

import javax.persistence.*;
import java.util.List;

/**
 * Created by  Tomek on 2016-03-19.
 */
@Entity
@Table(name = "grupy")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_GRUPY_ID")
public class GrupaOB extends BaseOB  {
    private String nazwa;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "UPRAWNIENIE_ID", referencedColumnName = "ID")
    private List<UprawnienieOB> uprawnienia;

    public GrupaOB() {
    }

    public GrupaOB(String nazwa, List<UprawnienieOB> uprawnienia) {
        this.nazwa = nazwa;
        this.uprawnienia = uprawnienia;
    }

    public List<UprawnienieOB> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(List<UprawnienieOB> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }


}
