package com.skpcp.elista.base.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-30.
 */

@ApiModel
public class ResponsDTO implements Serializable {
    private String napis;

    public ResponsDTO() {
    }

    public String getNapis() {
        return napis;
    }

    public void setNapis(String napis) {
        this.napis = napis;
    }

    public ResponsDTO(String napis) {
        this.napis = napis;
    }
}
