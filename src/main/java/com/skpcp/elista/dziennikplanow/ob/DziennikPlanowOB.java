package com.skpcp.elista.dziennikplanow.ob;

import com.skpcp.elista.base.ob.BaseOB;
import com.skpcp.elista.dziennikplanow.EDniTygodnia;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by   Tomek on 2016-03-19.
 */
@Entity
@Table(name="dziennikplanow")
@SequenceGenerator(initialValue = 1,name = "SEQ",sequenceName = "GEN_DZIENNIK_PLANOW_ID")
public class DziennikPlanowOB extends BaseOB implements Serializable{
    private Long idUzytkownika;
    private EDniTygodnia dzienTygodnia;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowOB() {

    }

    public DziennikPlanowOB(Long idUzytkownika, EDniTygodnia dzienTygodnia, Date planOd, Date planDo) {
        this.idUzytkownika = idUzytkownika;
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public Long getIdUzytkownika() {
        return idUzytkownika;
    }

    public void setIdUzytkownika(Long idUzytkownika) {
        this.idUzytkownika = idUzytkownika;
    }

    public EDniTygodnia getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(EDniTygodnia dzienTygodnia) {
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
