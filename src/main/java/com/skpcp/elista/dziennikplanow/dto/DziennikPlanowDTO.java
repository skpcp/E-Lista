package com.skpcp.elista.dziennikplanow.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.dziennikplanow.EDniTygodnia;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class DziennikPlanowDTO extends BaseDTO implements Serializable {
    private Long idUzytkownika;
    private EDniTygodnia dzienTygodnia;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowDTO() {

    }

    public DziennikPlanowDTO(Long id,Date techDate,Long idUzytkownika, EDniTygodnia dzienTygodnia, Date planOd, Date planDo) {
        super(id,techDate);
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


