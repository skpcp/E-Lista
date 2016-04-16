package com.skpcp.elista.grupy.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import com.skpcp.elista.uprawnienia.dto.UprawnienieDTO;
import com.skpcp.elista.uzytkownik.dto.UzytkownikDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;
import java.util.List;

/**
 * Created by  Tomek on 2016-03-20.
 */
@ApiModel
public class GrupaDTO extends BaseDTO{
    private String nazwa;
    private List<UzytkownikDTO> uzytkownicy;
    private List<UprawnienieDTO> uprawnienia;
    public GrupaDTO(){
    }

    public GrupaDTO(String nazwa, List<UzytkownikDTO> uzytkownicy, List<UprawnienieDTO> uprawnienia) {
        this.nazwa = nazwa;
        this.uzytkownicy = uzytkownicy;
        this.uprawnienia = uprawnienia;
    }

    public GrupaDTO(Long id, Date techDate, String nazwa, List<UzytkownikDTO> uzytkownicy, List<UprawnienieDTO> uprawnienia) {
        super(id, techDate);
        this.nazwa = nazwa;
        this.uzytkownicy = uzytkownicy;
        this.uprawnienia = uprawnienia;
    }

    public List<UprawnienieDTO> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(List<UprawnienieDTO> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<UzytkownikDTO> getUzytkownicy() {
        return uzytkownicy;
    }

    public void setUzytkownicy(List<UzytkownikDTO> uzytkownicy) {
        this.uzytkownicy = uzytkownicy;
    }
}
