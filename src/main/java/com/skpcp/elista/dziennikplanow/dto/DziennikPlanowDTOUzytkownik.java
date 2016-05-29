package com.skpcp.elista.dziennikplanow.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTOBezHasla;
import io.swagger.annotations.ApiModel;


import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class DziennikPlanowDTOUzytkownik extends BaseDTO {
    private UzytkownikDTOBezHasla uzytkownik;
    private String dzienTygodnia;
    private String planOd;
    private String planDo;

    public DziennikPlanowDTOUzytkownik() {
    }

    public DziennikPlanowDTOUzytkownik(UzytkownikDTOBezHasla uzytkownik, String dzienTygodnia, String planOd, String planDo) {
        this.uzytkownik = uzytkownik;
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public DziennikPlanowDTOUzytkownik(Long id, Date techDate, UzytkownikDTOBezHasla uzytkownik, String dzienTygodnia, String planOd, String planDo) {
        super(id, techDate);
        this.uzytkownik = uzytkownik;
        this.dzienTygodnia = dzienTygodnia;
        this.planOd = planOd;
        this.planDo = planDo;
    }

    public UzytkownikDTOBezHasla getUzytkownik() {
        return uzytkownik;
    }

    public void setUzytkownik(UzytkownikDTOBezHasla uzytkownik) {
        this.uzytkownik = uzytkownik;
    }

    public String getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(String dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
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
