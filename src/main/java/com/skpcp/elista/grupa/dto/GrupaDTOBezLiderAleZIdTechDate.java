package com.skpcp.elista.grupa.dto;

import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class GrupaDTOBezLiderAleZIdTechDate extends BaseDTO {
    String nazwa;

    public GrupaDTOBezLiderAleZIdTechDate() {
    }

    public GrupaDTOBezLiderAleZIdTechDate(String nazwa) {
        this.nazwa = nazwa;
    }

    public GrupaDTOBezLiderAleZIdTechDate(Long id, Date techDate, String nazwa) {
        super(id, techDate);
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
