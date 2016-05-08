package com.skpcp.elista.rola.dto;

import com.skpcp.elista.uprawnienia.dto.UprawnienieDTO;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Tomasz Komoszeski on 2016-05-07.
 */

@ApiModel
public class RolaDTOBezIdTechDate implements Serializable {
    private String nazwa;

    private List<UprawnienieDTO> uprawnienia;
    public RolaDTOBezIdTechDate(){
    }

    public RolaDTOBezIdTechDate(String nazwa, List<UprawnienieDTO> uprawnienia) {
        this.nazwa = nazwa;
        this.uprawnienia = uprawnienia;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<UprawnienieDTO> getUprawnienia() {
        return uprawnienia;
    }

    public void setUprawnienia(List<UprawnienieDTO> uprawnienia) {
        this.uprawnienia = uprawnienia;
    }
}
