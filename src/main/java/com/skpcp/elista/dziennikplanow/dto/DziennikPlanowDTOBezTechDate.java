package com.skpcp.elista.dziennikplanow.dto;

import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOEmail;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class DziennikPlanowDTOBezTechDate implements Serializable {
    private Long id;
    private UzytkownikDTOEmail uzytkownik;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowDTOBezTechDate() {
    }

    public DziennikPlanowDTOBezTechDate(Long id, UzytkownikDTOEmail uzytkownik, Date planOd, Date planDo) {
        this.id = id;
        this.uzytkownik = uzytkownik;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UzytkownikDTOEmail getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOEmail uzytkownik) {
        this.uzytkownik = uzytkownik;
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
