package com.skpcp.elista.uzytkownik.dto;

import com.skpcp.elista.uzytkownik.EStan;
import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-08.
 */
@ApiModel
public class UzytkownikDTOEmail implements Serializable {
    private String email;


    public UzytkownikDTOEmail(){}

    public UzytkownikDTOEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
