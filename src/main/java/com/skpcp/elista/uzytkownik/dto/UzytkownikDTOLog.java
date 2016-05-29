package com.skpcp.elista.uzytkownik.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

@ApiModel
public class UzytkownikDTOLog implements Serializable {
    private Long id;

    public UzytkownikDTOLog() {
    }

    public UzytkownikDTOLog(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
