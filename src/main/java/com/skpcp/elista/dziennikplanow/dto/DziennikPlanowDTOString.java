package com.skpcp.elista.dziennikplanow.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;


/**
 * Created by Achilles on 2016-05-31.
 */

@ApiModel
public class DziennikPlanowDTOString implements Serializable {
    private Long id;
    private Long uzytkownikId;
    private String planOd;
    private String planDo;

    public DziennikPlanowDTOString() {
    }

    public DziennikPlanowDTOString(Long id, Long uzytkownikId, String planOd, String planDo) {
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

    public String getPlanOd() {
        return planOd;
    }

    public void setPlanOd(String planOd) {
        this.planOd = planOd;
    }

    public String getPlanDo() {
        return planDo;
    }

    public void setPlanDo(String planDo) {
        this.planDo = planDo;
    }
}
