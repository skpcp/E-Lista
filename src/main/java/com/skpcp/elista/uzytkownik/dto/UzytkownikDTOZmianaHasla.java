package com.skpcp.elista.uzytkownik.dto;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

/**
 * Created by Tomasz Komoszeski on 2016-05-29.
 */

@ApiModel
public class UzytkownikDTOZmianaHasla  implements Serializable{
    private String email;
    private String haslo;
    private String noweHaslo;

    public UzytkownikDTOZmianaHasla() {
    }

    public UzytkownikDTOZmianaHasla(String email, String haslo, String noweHaslo) {
        this.email = email;
        this.haslo = haslo;
        this.noweHaslo = noweHaslo;
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

    public String getNoweHaslo() {
        return noweHaslo;
    }

    public void setNoweHaslo(String noweHaslo) {
        this.noweHaslo = noweHaslo;
    }
}
