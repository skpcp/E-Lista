package com.skpcp.elista.dziennikplanow.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class DziennikPlanowDTOBezUzytkownika extends BaseDTO {
    private String dzienTygodnia;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowDTOBezUzytkownika() {
    }

    public DziennikPlanowDTOBezUzytkownika(String dzienTygodnia, Date planOd, Date planDo) {
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public DziennikPlanowDTOBezUzytkownika(Long id, Date techDate, String dzienTygodnia, Date planOd, Date planDo) {
        super(id, techDate);
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
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
