package com.skpcp.elista.dziennikplanow.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import com.skpcp.elista.uzytkownik.ob.UzytkownikOB;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by   Tomek on 2016-03-19.
 */
@Entity
@Table(name="dziennikiplanow")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_DZIENNIK_PLANOW_ID")
public class DziennikPlanowOB extends BaseOB {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UZYTKOWNIK_ID",referencedColumnName = "ID")
    @NotNull
    private UzytkownikOB uzytkownik;
    private String dzienTygodnia;//tutaj możliwe , że będzie lepszy zwykły string ?
    @DateTimeFormat(pattern = "HH:mm" )
    private Date planOd;
    @DateTimeFormat(pattern = "HH:mm")
    private Date planDo;


    public DziennikPlanowOB() {

    }

    public DziennikPlanowOB(UzytkownikOB uzytkownik, String dzienTygodnia, Date planOd, Date planDo) {
        this.uzytkownik = uzytkownik;
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }


    public UzytkownikOB getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikOB uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    public Date getPlanOd() {
        return planOd;
    }

    public void setPlanOd(Date planOd) {
        this.planOd = planOd;
    }

    public Date getPlanDo() {
        return planDo;
    }

    public void setPlanDo(Date planDo) {
        this.planDo = planDo;
    }
}
