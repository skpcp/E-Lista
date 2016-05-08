package com.skpcp.elista.dziennikplanow.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class DziennikPlanowDTO extends BaseDTO {
    private UzytkownikDTO uzytkownik;
    private String dzienTygodnia;
    private Date planOd;
    private Date planDo;

    public DziennikPlanowDTO() {
    }

    public DziennikPlanowDTO(Long id, Date techDate, UzytkownikDTO uzytkownik, String dzienTygodnia, Date planOd, Date planDo) {
        super(id,techDate);
        this.uzytkownik = uzytkownik;
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }



    public UzytkownikDTO getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTO uzytkownik) {
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


