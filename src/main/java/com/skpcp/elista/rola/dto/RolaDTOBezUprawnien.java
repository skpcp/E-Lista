package com.skpcp.elista.rola.dto;



import io.swagger.annotations.ApiModel;

import java.io.Serializable;


/**
 * Created by Tomasz Komoszeski on 2016-05-07.
 */

@ApiModel
public class RolaDTOBezUprawnien implements Serializable {
    String nazwa;

    public RolaDTOBezUprawnien(String nazwa) {
        this.nazwa = nazwa;
    }

    public RolaDTOBezUprawnien(){

    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }
}
