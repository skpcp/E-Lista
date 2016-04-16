package com.skpcp.elista.uprawnienia.dto;


import com.skpcp.elista.base.dto.BaseDTO;
import io.swagger.annotations.ApiModel;

import java.util.Date;


/**
 * Created by Tomasz Komoszeski on 2016-04-16.
 */
@ApiModel
public class UprawnienieDTO extends BaseDTO {
    private String nazwa;

    public UprawnienieDTO() {
    }

    public UprawnienieDTO(Long id, Date techDate, String nazwa) {
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
