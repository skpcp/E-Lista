package com.skpcp.elista.uzytkownik.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

@ApiModel
public class UzytkownikDTOZaloguj implements Serializable {
    private String email;
    private String haslo;

    public UzytkownikDTOZaloguj() {
    }

    public UzytkownikDTOZaloguj(String email, String haslo) {
        this.email = email;
        this.haslo = haslo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }
}
