package com.skpcp.elista.dziennikplanow.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class DziennikPlanowDTOBezTechDate implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowDTOBezTechDate() {
    }

    public DziennikPlanowDTOBezTechDate(Long id, Long uzytkownikId, Date planOd, Date planDo) {
        this.id = id;
        this.uzytkownikId = uzytkownikId;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUzytkownikId() {
        return uzytkownikId;
    }

    public void setUzytkownikId(Long uzytkownikId) {
        this.uzytkownikId = uzytkownikId;
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
